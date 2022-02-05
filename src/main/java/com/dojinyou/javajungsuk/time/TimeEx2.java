package com.dojinyou.javajungsuk.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimeEx2 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate yesterday1 = today.minus(1, ChronoUnit.DAYS);
        LocalDate yesterday2 = today.minusDays(1);
        System.out.println(today);
        System.out.println(yesterday1);
        System.out.println(yesterday2);
    }
}
