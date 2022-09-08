package com.company.java_algorithm_study.section4_hash;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 학생수
        String vote = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char v : vote.toCharArray()){
            map.put(v, map.getOrDefault(v, 0)+1);
        }
        // map 객체에는 특정 키가 존재하는지도 알 수 있다.
        System.out.println(map.containsKey('A')); // A 라는 키가 존재하는지
        System.out.println(map.size());
        System.out.println(map.remove('A')); // A 라는 키를 삭제


        int max = 0;
        char answer = ' ';
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }
}
