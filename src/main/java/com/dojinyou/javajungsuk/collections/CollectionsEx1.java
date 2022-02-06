package com.dojinyou.javajungsuk.collections;

import java.util.*;

public class CollectionsEx1 {
    public static void main(String[] args) {
        /*
        Collections는 크게 List / Set / Map 으로 구성되어 있다.
        List와 Set은 공통적인 부분을 뽑아서 Collections라는 Interface가 있다.
        Map은 이들과 동작 방식이 달라 별도로 되어 있다.
        Collections Framework에 있는 모든 클래스들은 이 3가지 중 하나를 구현하고 있다.
        다만, Vector, Stack, Hashable, Properties와 같은 클래스들은
        Collections Framework가 생기기 전부터 사용되어 있어 명명법이 다르게 되어 있다.
        기존 컬레션들 호환을 위해서 남겨두었지만, 가능한 사용하지 않는 것이 좋다.
        대신 ArrayList와 HashMap을 사용하자.
        */

        // List Interface의 구현체들
        List<Object> arrayList = new ArrayList<Object>();
        List<Object> linkedList = new LinkedList<Object>();
        List<Object> stack = new Stack<Object>();
        List<Object> Vector = new Vector<Object>();

        // Set Interface의 구현체들
        Set<Object> hashSet = new HashSet<Object>();
        Set<Object> treeSet = new TreeSet<Object>();

        // Map Interface의 구현체들
        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        Map<Object, Object> treeMap = new TreeMap<Object, Object>();
        Map<Object, Object> hashTable = new Hashtable<Object, Object>();
        Map<Object, Object> properties = new Properties();
    }
}
