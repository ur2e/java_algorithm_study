package com.company.baekjoon;

import java.io.*;
import java.util.*;

public class 단어정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String word = br.readLine();
            map.put(word, word.length());
        }

        List<String> keySet = new ArrayList<>(map.keySet());


        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(map.get(o1) == map.get(o2)){
                    return o1.compareTo(o2);
                } else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });


        for(String key : keySet){
            System.out.println(key);
        }
    }
}
