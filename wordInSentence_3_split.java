package com.company.java_algorithm_study;

import java.util.Scanner;

public class wordInSentence_3_split {
    public String solution(String str){
        String answer = " ";
        int maxLen = Integer.MIN_VALUE; // 가장 작은 값으로 초기화
        String[] s = str.split(" ");
        for (String x : s){
            int len = x.length();
            if (len > maxLen) {
                maxLen = len;
                answer = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        wordInSentence_3_split T = new wordInSentence_3_split();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
