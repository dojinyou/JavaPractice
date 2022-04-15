package com.dojinyou.javajungsuk.formatting;

import java.text.ChoiceFormat;

public class ChoiceForamtEx2 {
    public static void main(String[] args) {
        String pattern1 = "60#D|70#C|80#B|90#A";
        String pattern2 = "60<D|70<C|80<B|90<A";

        ChoiceFormat cf1 = new ChoiceFormat(pattern1);
        ChoiceFormat cf2 = new ChoiceFormat(pattern2);

        int[] scores = {99,90,80,70,60};

        for (int score : scores) {
            System.out.println(score+"=> #format : "+cf1.format(score)+", <format : "+cf2.format(score));
        }
        /*
        * 99=> #format : A, <format : A
        * 90=> #format : A, <format : B
        * 80=> #format : B, <format : C
        * 70=> #format : C, <format : D
        * 60=> #format : D, <format : D
        * */
    }
}
