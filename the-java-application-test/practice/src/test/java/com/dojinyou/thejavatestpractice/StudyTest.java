package com.dojinyou.thejavatestpractice;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    // 모든 테스트가 실행 전 딱 1번 호출됨.
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }


    // 각 테스트가 실행 전 1번 호출됨.
    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled // 테스트를 하지 않음.
    void otherTest() {
        System.out.println("other test");
    }

    // 각 테스트가 실행 후 1번 호출됨.
    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    // 모든 테스트가 실행 후 딱 1번 호출됨.
    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

}