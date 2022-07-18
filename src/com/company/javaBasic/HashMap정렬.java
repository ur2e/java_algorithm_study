package com.company.javaBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMap정렬 {
    public static void main(String[] args) {
        /* Value 기준 */
        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

        List<String> keySet = new ArrayList<>(map.keySet());

        //value 기준으로 내림차순 정렬
        System.out.println("value 기준 내림차순 정렬");
        keySet.sort((o1, o2) -> map.get(o2) - map.get(01));
        for(String key: keySet) {
            System.out.println(key+ " " + map.get(key));
        }

    }
}
