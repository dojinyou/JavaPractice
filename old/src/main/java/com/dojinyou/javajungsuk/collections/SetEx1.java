package com.dojinyou.javajungsuk.collections;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

public class SetEx1 {
    public static void main(String[] args) {
        // Set interface는 중복을 허락하지 않고 저장순서가 유지되지 않는다.
        Set<String> set = new HashSet<String>();

        MessageFormat mf = new MessageFormat("set-{0}");
        for (int i = 1;i<5;i++) {
            String sampleData = mf.format(new String[]{Integer.toString(i)});
            set.add(sampleData);
        }

        System.out.println("set = " + set); // set = [set-1, set-2, set-3, set-4]

        boolean hasSet1 = set.contains("set-1");
        System.out.println("hasSet1 = " + hasSet1); // hasSet1 = true

        for (int i = 1;i<5;i++) {
            set.add("set-duplicate");
        }

        System.out.println("set = " + set); // set = [set-1, set-2, set-3, set-duplicate, set-4]
    }
}
