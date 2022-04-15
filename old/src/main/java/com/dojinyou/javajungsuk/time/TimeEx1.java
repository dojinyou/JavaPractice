package com.dojinyou.javajungsuk.time;

import java.time.*;

public class TimeEx1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime dateTimeKr = ZonedDateTime.now();

        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);
        System.out.println("dateTimeKr = " + dateTimeKr);
        /*
        * date = 2022-02-05
        * time = 17:07:30.753336500
        * dateTime = 2022-02-05T17:07:30.753336500
        * dateTimeKr = 2022-02-05T17:07:30.754415+09:00[Asia/Seoul]
        * */

        date = LocalDate.of(2022,02,05);
        time = LocalTime.of(17,07,30);
        dateTime = LocalDateTime.of(2022,02,05,17,07,30);
        dateTimeKr = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));


        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);
        System.out.println("dateTimeKr = " + dateTimeKr);
        /*
         * date = 2022-02-05
         * time = 17:07:30
         * dateTime = 2022-02-05T17:07:30
         * dateTimeKr = 2022-02-05T17:07:30+09:00[Asia/Seoul]
         * */
    }
}
