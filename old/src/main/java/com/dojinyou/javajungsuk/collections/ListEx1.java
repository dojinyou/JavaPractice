package com.dojinyou.javajungsuk.collections;

import java.text.MessageFormat;
import java.util.*;

public class ListEx1 {
    public static void main(String[] args) {
        // List Interface는 중복을 허용하면서 저장순서가 유지된다.
        List<String> list = new ArrayList<String>();
        
        // add - 지정된 index에 해당 데이터를 추가
        int idx = 0;
        String value = "index-0";
        list.add(idx, value);

        System.out.println("list = " + list); // list = [index-0]
        List<String> addedList = new ArrayList<String>();
        MessageFormat mf = new MessageFormat("index-{0}");
        for (int i = 1;i<5;i++) {
            String sampleData = mf.format(new String[]{Integer.toString(i)});
            addedList.add(sampleData);
        }

        list.addAll(idx, addedList);
        System.out.println("list = " + list); // list = [index-1, index-2, index-3, index-4, index-0]

        // get - index의 위치의 값을 반환합니다.
        String getValue = list.get(idx);
        System.out.println("getValue = " + getValue); // getValue = index-1

        // indexOf, lastIndexOf - 해당 객체의 인덱스를 반환
        // 탐색 방향 => indexOf : 정방향, lastIndexOf :역방향)
        int indexOfindex1 = list.indexOf("index-1");
        System.out.println("indexOfindex1 = " + indexOfindex1); // 0

        int lastIndexOfindex1 = list.lastIndexOf("index-1");
        System.out.println("lastIndexOfindex1 = " + lastIndexOfindex1); // 0

        // remove - 지정된 위치의 데이터를 삭제하고 해당 데이터를 반환한다 / return Object
        String lastValue = list.remove(list.size()-1);
        System.out.println("lastValue = " + lastValue); // lastValue = index-0

        // set - 지정된 위치에 해당 데이터를 저장한다.
        String newData = "newData";
        list.set(1,newData);
        System.out.println("list = " + list); // list = [index-1, newData, index-3, index-4]

        // sort - 지정된 comparator를 이용하여 list를 정렬 / return void
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("list = " + list); // list = [index-1, index-3, index-4, newData]

        // subList - 지정된 범위에 있는 부분 리스트를 반환한다.
        List<String> subList = list.subList(0, 1);
        System.out.println("subList = " + subList); // subList = [index-1]
    }
}
