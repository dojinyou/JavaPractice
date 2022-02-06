package com.dojinyou.javajungsuk.collections;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {
    public static void main(String[] args) {
        // Map은 Key와 Value를 쌍으로 묶어서 저장한다.
        // Key는 중복이 되지 않고, Value는 중복이 가능하다.
        // 동일한 Key에 대해서 새로운 Value값을 저장할 시에는 새롭게 저장된 데이터가 남는다.
        Map<String, String> map = new HashMap<String, String>();

        MessageFormat kmf = new MessageFormat("key{0}");
        MessageFormat vmf = new MessageFormat("value{0}");
        for(int i = 0; i<5;i++) {
            String key = kmf.format(new String[]{Integer.toString(i)});
            String value = vmf.format(new String[]{Integer.toString(i)});
            map.put(key, value);
        }
        System.out.println("map = " + map);
        // map = {key1=value1, key2=value2, key0=value0, key3=value3, key4=value4}

        boolean hasKey = map.containsKey("key1");
        System.out.println("hasKey = " + hasKey);
        boolean hasValue = map.containsValue("value1");
        System.out.println("hasValue = " + hasValue);

        int size = map.size();
        System.out.println("size = " + size);

        Set<String> keySet = map.keySet();
        System.out.println("keySet = " + keySet);
        // keySet = [key1, key2, key0, key3, key4]

        Collection<String> valueSet = map.values();
        System.out.println("valueSet = " + valueSet);
        // valueSet = [value1, value2, value0, value3, value4]

    }
}
