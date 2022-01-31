package com.dojinyou.javajungsuk.operator;

import java.util.Random;

public class StringBufferExam {
    public String randomName() {
        StringBuffer sb = new StringBuffer();
        String[] firstNames = {"Tod", "John", "Michael"};
        String[] lastNames = {"Smith", "Brown", "Davis"};

        // 0~2 사이의 임의의 숫자를 골라서
        int random1 = new Random().nextInt(3);
        // 랜덤하게 이름을 뽑는다.
        String firstName = firstNames[random1];


        // 0~2 사이의 임의의 숫자를 골라서
        int random2 = new Random().nextInt(3);
        // 랜덤하게 성을 뽑는다.
        String lastName = lastNames[random2];

        // sb에 이름(firstName) 공백(" ") 성(lastname) 순으로 append해 보세요.
        // 단 메소드 체이닝을 이용해야 합니다.
        return sb.append(firstName).append(" ").append(lastName).toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        // 해당 스트링 버퍼에 "hello", 공백, "world"를 차례대로 추가

        sb.append("hello");
        sb.append(" ");
        sb.append("world");
        // StringBuffer에 추가된 값을 toString()메소드를 이용하여 반환

        String str = sb.toString();

        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = sb2.append("hello"); // this가 반환됨.
        if (sb2 == sb3) {
            System.out.println("sb2 == sb3");
        }

        String str2 = new StringBuffer().append("hello").append(" ").append("world").toString();
        System.out.println(str2);
    }
}
