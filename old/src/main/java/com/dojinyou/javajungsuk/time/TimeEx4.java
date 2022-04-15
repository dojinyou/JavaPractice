package com.dojinyou.javajungsuk.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeEx4 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.printf("%d년 %d월 %d일%n", today.getYear(),today.getMonthValue(),today.getDayOfMonth());
        // 2022년 2월 5일

        LocalTime now = LocalTime.now();
        System.out.printf("%d시 %d분 %d초%n", now.getHour(),now.getMinute(),now.getSecond());
        // 17시 29분 6초

        LocalDate twoYearsAgo = today.minusYears(2);
        System.out.println(twoYearsAgo); // 2020-02-05
        LocalDate twoMonthsAgo = today.minusMonths(2);
        System.out.println(twoMonthsAgo); // 2021-12-05
        LocalDate twoDaysAgo = today.minusDays(2);
        System.out.println(twoDaysAgo); // 2022-02-03

        LocalDate goTo2002 = today.withYear(2002);
        System.out.println(goTo2002); // 2002-02-05

        LocalTime twoHoursAgo = now.minusHours(2);
        System.out.println(twoHoursAgo); // 15:36:00.875918500

        // truncatedTo Unit 이하 값을 모두 0으로 만듬.
        // LocalDate에는 없음. (Date에는 0이라는 값이 없기 떄문에)
        LocalTime truncatedTime = now.truncatedTo(ChronoUnit.HOURS);
        System.out.println(truncatedTime); // 17:00


    }
}
