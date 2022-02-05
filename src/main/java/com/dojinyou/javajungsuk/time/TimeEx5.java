package com.dojinyou.javajungsuk.time;

import java.time.LocalDate;

public class TimeEx5 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate now = LocalDate.now();
        LocalDate twoDaysAgo = today.minusDays(2);
        LocalDate afterTwoDays = today.plusDays(2);

        System.out.println(today.compareTo(now)); // 0
        System.out.println(today.compareTo(twoDaysAgo)); // 2
        System.out.println(today.compareTo(afterTwoDays)); // -2

        System.out.println(today.isEqual(now)); // true
        System.out.println(today.isEqual(twoDaysAgo)); // false
        System.out.println(today.isEqual(afterTwoDays)); // false

        System.out.println(today.isAfter(now)); // false
        System.out.println(today.isAfter(twoDaysAgo)); // true
        System.out.println(today.isAfter(afterTwoDays)); // false

        System.out.println(today.isBefore(now)); // false
        System.out.println(today.isBefore(twoDaysAgo)); // false
        System.out.println(today.isBefore(afterTwoDays)); // true
    }
}
