package com.dojinyou.javajungsuk.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsEx2 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();

        // Collections Interface Methods
        // add - 데이터 추가 / return Boolean
        list.add("Object"); // 단일 객체 추가
        
        List<Object> addedList = new ArrayList<Object>();
        list.add(addedList); // Collections 추가

        // clear - 데이터 전부 삭제 / return void
        list.clear();

        // contains - 데이터 포함 여부 / return boolean
        boolean hasObject = list.contains("Object");
        System.out.println("hasObject = " + hasObject);


        List<Object> templedList = new ArrayList<Object>();
        boolean hasCollections = list.contains(templedList);
        System.out.println("hasCollections = " + hasCollections);

        // isEmpty - 데이터가 없는 지 여부 / return boolean
        boolean isEmpty = list.isEmpty();
        System.out.println("isEmpty = " + isEmpty);

        // iterator - iterator 반환 / return Iterator
        Iterator<Object> it = list.iterator();
        while ( it.hasNext() ) {
            Object iterItem = it.next();
            System.out.println("iterItem = " + iterItem);
        }

        // remove - 데이터 제거 / return boolean
        list.remove("Object");

        List<Object> deletedList = new ArrayList<Object>();
        list.removeAll(deletedList);

        // retainAll - 지정된 객체를 제외하고 모두 삭제 / return boolean
        List<Object> retainList = new ArrayList<Object>();
        list.retainAll(retainList);
        
        // size - 가지고 있는 객체 수 확인 / return int
        list.size();

        // toArray - 객체 배열 타입으로 반환 / return Object[]
        list.toArray();
    }
}
