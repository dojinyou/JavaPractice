package com.dojinyou.javajungsuk.formatting;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatting {
    public static void main(String[] args) {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        Date todayCal = cal.getTime();

        SimpleDateFormat sdf1,sdf2,sdf3,sdf4;

        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
        sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        sdf4 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh:mm:ss.SSS");

        System.out.println("sdf1 = " + sdf1.format(today));
//      System.out.println("sdf1 = " + sdf1.format(todayCal));
//      sdf1 = 2022-02-05
        System.out.println("sdf2 = " + sdf2.format(today));
//      System.out.println("sdf2 = " + sdf2.format(todayCal));
//      sdf2 = 2022년 02월 05일 오후 03:29:41
        System.out.println("sdf3 = " + sdf3.format(today));
//      System.out.println("sdf3 = " + sdf3.format(todayCal));
//      sdf3 = 2022년 02월 05일 15:29:41
        System.out.println("sdf4 = " + sdf4.format(today));
//      System.out.println("sdf4 = " + sdf4.format(todayCal));
//      sdf4 = 2022년 02월 05일 토요일 03:29:41.239
    }
}
