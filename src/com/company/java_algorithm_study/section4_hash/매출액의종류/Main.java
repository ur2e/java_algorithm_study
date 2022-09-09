package com.company.java_algorithm_study.section4_hash.매출액의종류;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private String solution(String s1, String s2){
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(char x : s2.toCharArray()){
            // 먼저 키가 존재하는지 하지않는지 파악
            // 존재하지 않으면 아나그램 X
            if(!map.containsKey(x) || map.get(x) == 0)  return "NO";
            map.put(x, map.get(x)-1);
        }

        return answer;
    }
    public static void main(String[] args) {
        // 나는 해쉬맵 2개 만들어서
        // 각 문장의 알파벳, 개수를 셌다.
        // 강사님은 하나의 해쉬맵을 만들어서
        // 1번 문장 돌 때는 ++하고
        // 2번 문장 돌 때는 --했다.

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.solution(a, b));
    }
}
