package com.company.CollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        // Generic 지정핳 때 String으로 했으니 값도 String으로 넣어주자
        map.put("001", "ji");
        map.put("002", "yang");
        map.put("003", "lee");

        map.put("001", "kang");

        System.out.println(map.size()); // 3


        // 나중에 다시 들어온 kang이 출력된다.
        System.out.println(map.get("001"));

        // map이 가진 모든 key 값이 다 꺼내줘
        Set<String> keys = map.keySet();

        // 방법 1) forEach문
        for(String key: keys) {
            System.out.println(map.get(key));
        }

        // 방법 2) iterator
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
