package com.dojinyou.javajungsuk.formatting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateFormattingParseEx  {
    public static void main(String[] args) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "yyyy년 MM월 dd일";
        SimpleDateFormat inputSdf = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputSdf = new SimpleDateFormat(outputPattern);


        Date inputDate = null;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("날짜를 "+inputPattern+ "의 형태로 입력해주세요. Ex) 2022-02-05");

            while(sc.hasNextLine()) {
                try {
                    inputDate = inputSdf.parse(sc.nextLine());
                    break;
                } catch (ParseException e) {
                    System.out.println("정확하게 입력해주세요.");
                }
            }

            System.out.println("입력하신 날짜는 "+ outputSdf.format(inputDate) + "입니다.");
        } catch (Exception error) {
            System.out.println("에러가 발생했습니다.");
            System.out.println(error.getClass());
            System.out.println(error.toString());
            System.out.println(error.getMessage());
        }


    }
}
