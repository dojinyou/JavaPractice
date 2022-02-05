package com.dojinyou.javajungsuk.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeEx3 {
    public static void main(String[] args) {
        LocalDate today1 = LocalDate.now();
        LocalDate today2 = LocalDate.of(2022,02,05);
        LocalDate today3 = LocalDate.ofYearDay(2022,36);
        LocalDate today4 = LocalDate.parse("2022-02-05");

        System.out.println(today1); // 2022-02-05
        System.out.println(today2); // 2022-02-05
        System.out.println(today3); // 2022-02-05
        System.out.println(today4); // 2022-02-05

        LocalTime now1 = LocalTime.now();
        LocalTime now2 = LocalTime.of(17,05,05);
        LocalTime now3 = LocalTime.ofSecondOfDay(17*3600+5*60+5);
        LocalTime now4 = LocalTime.parse("17:05:05");

        System.out.println(now1); // 17:22:46.277638500
        System.out.println(now2); // 17:05:05
        System.out.println(now3); // 17:05:05
        System.out.println(now4); // 17:05:05
    }
}
