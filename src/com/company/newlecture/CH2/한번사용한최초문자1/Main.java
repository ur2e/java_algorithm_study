package com.company.newlecture.CH2.한번사용한최초문자1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    private int solution(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

//        for(char c: map.keySet()){
//            if(map.get(c) == 1) return i+1; // 인덱스 계산할 변수 하나 더 두어야하니까 for문 써라
//        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1) {
                return i+1;
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
