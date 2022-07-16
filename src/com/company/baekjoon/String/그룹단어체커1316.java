package com.company.baekjoon.String;

import java.io.*;


public class 그룹단어체커1316 {
    static int solution(String[] words){
        int answer = words.length;
        for(String str : words){
            int[] arr = new int[26];
            char before = '0';
            for(char x: str.toCharArray()){
                if(arr[(int)x-97] == 0){
                    arr[(int)x-97] = 1;
                } else if (before != x) {
                    answer--;
                    break;
                }
                before = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        그룹단어체커1316 T = new 그룹단어체커1316();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        System.out.println(T.solution(words));
    }
}
