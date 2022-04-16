package com.dojinyou.thejavatestpractice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


// 테스트 클래스는 각 메소드마다 새로운 테스트 클래스 인스턴스를 생성한다.
// 왜냐하면 각 테스트간의 의존성을 제거하기 위해서이다.
// 하나의 인스턴스를 가지고 여러 테스트 케이스를 검증하는 방법은
// 테스트 인스턴스의 생명주기를 클래스 단위로 만들어주는 것!
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudyTest {

    // 모든 테스트가 실행 전 딱 1번 호출됨.
    @BeforeAll
    @DisplayName("모든 테스트를 시작하기 전에")
    static void beforeAll() {
        System.out.println("before all");
    }


    // 각 테스트가 실행 전 1번 호출됨.
    @BeforeEach
    @DisplayName("각 테스트를 시작하기 전에")
    void beforeEach() {
        System.out.println("before each");
    }

    @Test
    @DisplayName("메시지 처리 관련 테스트")
    void AssertMessageTest() {
        Study study = new Study(-10);

        // 아래 2가지의 차이점
        // lambda funtion을 이용하면 실패시에만 해당 함수가 호출된다.
        // 하지만 String으로 Message를 전달할 경우 매번 String 연산을 시행하기 때문에 Overhead가 발생한다.
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT +"이다.");
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "이다.");
    }

    @Test
    @DisplayName("test가 여러 케이스일 경우에 테스트")
//    @Disabled // 테스트를 하지 않음.
    void otherTest() {
        Study study = new Study(-10);

        // Test가 이런식으로 여러 Assert 문이 있을 때,
        // 중간에 실패하는 경우 이후 테스트를 실행하지 않는다.
//        assertNotNull(study);
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), ()-> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT +"이다.");
//        assertTrue(study.getNumOfMaximumMembers() > 0, ()->"최대인원은 0보다 커야합니다");

        // 이를 해결할 수 있는 방법은 AssertAll
        // 이런식으로 람다 함수로 묶어서 넣어주면 실패여부와 상관없이 모든 테스트를 실행한다.
        assertAll(() -> assertNotNull(study), () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "이다."), () -> assertTrue(study.getNumOfMaximumMembers() > 0, () -> "최대인원은 0보다 커야합니다"));
    }

    @Test
    @DisplayName("Throw Exception 테스트")
    void ExceptionTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-1));
        assertEquals("number of maxnimum member is must bigger than 0", exception.getMessage());
    }

    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("반복 테스트")
    void repeatedTest() {
    }

    @ParameterizedTest(name = "{index}-{displayName}, value={0}")
    @ValueSource(strings = {"문자열", "여러", "개를", "받는", "법"})
    @DisplayName("파라미터 반복 테스트 테스트")
    void parameterizedTest(String value) {
        System.out.println(value);
    }

    @ParameterizedTest(name = "{index}-{displayName}, value={0}")
    @ValueSource(ints = {1,5,10})
    @DisplayName("파라미터 반복 테스트 테스트 with 타입 변환기")
    void parameterizedTestWithConverter(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getNumOfMaximumMembers());
    }

    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Study Type으로만 변환시킬 수 있습니다.");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @ParameterizedTest(name = "{index}-{displayName}, limit={0}, name={1}")
    @CsvSource({"1,'도진01'","5,'도진02'","10,'도진03'"})
    @DisplayName("반복테스트 with CsvSource")
    void parameterizedTestWithCSVSource(int numOfMaxMem, String name) {
        System.out.println(new Study(numOfMaxMem,name));
    }

    @ParameterizedTest(name = "{index}-{displayName}, limit={0}, name={1}")
    @CsvSource({"1,'도진01'","5,'도진02'","10,'도진03'"})
    @DisplayName("반복테스트 with Aggregator")
    void parameterizedTestWithCSVSourceAndAggregator(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            int maxMember = accessor.getInteger(0);
            String name = accessor.getString(1);
            return new Study(maxMember,name);
        }
    }

    @Test
    @DisplayName("Duration 테스트")
    void DurationTest() {
        assertAll(() -> assertTimeout(Duration.ofSeconds(10), () -> new Study(10)),
                  // 호출한 함수가 다 동작해야 종료
                  () -> assertTimeout(Duration.ofMillis(100), () -> {
                      new Study(10);
                      Thread.sleep(300);
                  }),
                  // 예상되는 시간보다 초과되면 바로 종료
                  () -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                      new Study(10);
                      Thread.sleep(300);
                  }));
        // Preemptively를 사용할 경우 
        // Thread Local을 전략(Transaction)으로 사용하는 케이스에 대해서 테스트가 제대로 되지 않을 수 있음
        // 그럴 경우에는 기본 Timeout을 사용하는 걸 권장

    }

    @Test
    @DisplayName("Test를 작성하는 다른 방법: AssertThat")
    void assertThatTest() {
        Study study = new Study(2);
        // 위에서 작성한 최대 인원에 대한 제한 테스트를 assertThat을 이용해서 작성하기
        // 기존의 assertTrue 방식의 테스트 코드
//        assertTrue(study.getNumOfMaximumMembers() > 10, ()->"최대인원은 10보다 커야합니다");
        // assertThat을 이용한 테스트 코드
        // 사용하기 위해서 assertJ에서 import를 해주어야 함.
        assertThat(study.getNumOfMaximumMembers()).as(() -> "최대인원은 0보다 커야합니다.")
                                                  .isGreaterThan(0);

    }

    // 각 테스트가 실행 후 1번 호출됨.
    @AfterEach
    @DisplayName("각 테스트를 실행된 후에")
    void afterEach() {
        System.out.println("after each");
    }

    // 모든 테스트가 실행 후 딱 1번 호출됨.
    @AfterAll
    @DisplayName("모든 테스트를 실행된 후에")
    static void afterAll() {
        System.out.println("after all");
    }

}