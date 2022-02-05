package com.dojinyou.javajungsuk.formatting;

import java.text.ChoiceFormat;

public class ChoiceFormatEx {
    public static void main(String[] args) {
        double[] limits = {60,70,80,90};
        String[] values = {"D","C","B","A"};
        ChoiceFormat cf = new ChoiceFormat(limits,values);

        int[] scores = {100,95,88,80,52,60,70};

        for (int score : scores) {
            System.out.println(score+":"+cf.format(score));
        }
        /* limits 범위에 따라 value가 할당되는 것을 알 수 있음.
        100:A
        95:A
        88:B
        80:B
        52:D
        60:D
        70:C
        */

    }
}
