package com.company.baekjoon.String.복호화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public StringBuilder solution(String[] arr){
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map;
        for(String str: arr){
            map = new HashMap<>();
            for(char x: str.toCharArray()){
                if(x != ' '){
                    map.put(x, map.getOrDefault(x, 0)+1);
                }
            }

            int max = Integer.MIN_VALUE;
            boolean check = false;
            char answer=' ';
            for(char x: map.keySet()){
                if(map.get(x) > max){
                    max = map.get(x);
                    answer = x;
                    check = false;
                } else if (map.get(x) == max) {
                    check = true;
                }
            }
            if(check)   sb.append("?").append(System.lineSeparator());
            else sb.append(answer).append(System.lineSeparator());
        }

        sb.deleteCharAt(sb.length()-1);
        return sb;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[n];

        for(int i = 0; i < n; i++){
            strs[i] = br.readLine();
        }

        System.out.println(T.solution(strs));
    }
}
