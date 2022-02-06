package com.dojinyou.javajungsuk.collections;

import java.util.ArrayList;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("string");
        arrayList1.add(1);
        System.out.println("arrayList1 = " + arrayList1); // arrayList = [string, 1]

        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("string");
        // arrayList2.add(1); // error
        arrayList2.add("newString");
        System.out.println("arrayList2 = " + arrayList2); // arrayList2 = [string, newString]

        ArrayList arrayList3 = new ArrayList(2);
        // ArrayList 동적 배열로 초기 배열의 길이를 지정하여 배열 확장에서 발생하는 오버헤드를 제어할 수 있다.
    }
}
