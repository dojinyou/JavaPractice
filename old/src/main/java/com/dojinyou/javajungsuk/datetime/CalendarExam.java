package com.dojinyou.javajungsuk.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExam {
    /*
    jdk 1.0 - Date
    jdk 1.1 - Calendar
    jdk 1.8 - java.time package

    위와 같이 버전에 따라 날짜와 시간을 나타내는 클래스가 변해왔다.
    java.time package만 배우면 좋겠지만, 1.8 이전까지 자바의 탄생부터 20년간 사용되어 왔고,
    지금도 사용 중이기 때문에 알고 넘어가야 한다.


    Calendar는 추상클래스이기 때문에 생성자를 통해 객체를 생성할 수 없다.
    이를 구현한 클래스인 GregorianCalendar를 생성해서 사용해야 한다.
    지역별로 날짜 계산이 다르거나 혹은 날짜에 대한 다른 규칙이 생기는 것을 고려하여
    GregorianCalendar를 통해 직접 객체를 생성하는 것보다 getInstance static method를 통해서 호출하는 것이 좋다.
    > Calendar.getInstance()
        Calendar class는 추상 클래스이기 떄문에
        객체를 생성할 수 없어 static method를 통해서 객체를 가져온다.
    */

    public static void main(String[] args) {
        // GregorianCalendar를 이용해서 직접 객체 생성하기
        Calendar gregorianCal = new GregorianCalendar();

        // getInstance static method를 이용해서 객체 생성하기.
        Calendar getInstanceCal = Calendar.getInstance();

        // Calendar 객체와 Date 객체간의 변환
        // Calendar -> Date
        Calendar calOrigin = Calendar.getInstance();
        Date d = new Date(calOrigin.getTimeInMillis());

        // Date -> Calendar
        Date dateOrigin = new Date();
        Calendar calConvertion = Calendar.getInstance();
        calConvertion.setTime(dateOrigin);

        // Calendar 객체는 생성시에 생성 날짜를 기준으로 초기화된다.
        Calendar today = Calendar.getInstance();

        System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
        System.out.println("월(0~11, 0:1월): "	+ today.get(Calendar.MONTH));
        System.out.println("이 해의 몇 째 주: "		+ today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇 째 주: "		+ today.get(Calendar.WEEK_OF_MONTH));
        // DATE와 DAY_OF_MONTH는 같다.
        System.out.println("이 달의 몇 일: "		+ today.get(Calendar.DATE));
        System.out.println("이 달의 몇 일: "		+ today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 해의 몇 일: "		+ today.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일(1~7, 1:일요일): " + today.get(Calendar.DAY_OF_WEEK)); // 1:일요일, 2:월요일, ... 7:토요일
        System.out.println("이 달의 몇 째 요일: "	+ today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전_오후(0:오전, 1:오후): " + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11): "	+ today.get(Calendar.HOUR));
        System.out.println("시간(0~23): "	+ today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59): "	+ today.get(Calendar.MINUTE));
        System.out.println("초(0~59): "	+ today.get(Calendar.SECOND));
        System.out.println("1000분의 1초(0~999): " + today.get(Calendar.MILLISECOND));

        // 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
        System.out.println("TimeZone(-12~+12): " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
        System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE) ); // 이 달의 마지막 일을 찾는다.


         /*
         set을 통해서 날짜를 지정할 수 있다.
         add를 통해 원하는 날짜 만큼 증가, 감소 시킬 수 있다.
         add와 유사하게 roll을 통해서도 날짜를 증가, 감소 시킬 수 있다.
         add와 roll의 차이는 원하는 필드를 제외한 나머지 필드에 대한 영향력 여부이다.

         add의 경우 증감을 통해 해당 필드외에 영향을 미치게 될 경우 자동으로 그 값을 반영해준다.
         이에 반해, roll의 경우에는 다른 필드의 변화 없이 해당 필드만을 변화 시킨다.
         단, roll을 통해 Calendar.MONTH 변화의 경우 DATE가 말일 일 떄 경우에 따라 MONTH의 변경에 의해 DATE로 변경된다.

         */


    }
}
