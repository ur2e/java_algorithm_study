package com.company.java_algorithm_study.Section1_String;

import java.util.Scanner;

public class 팰린드롬_replaceAll {
    public String solution(String str) {
        String answer = "NO";
        // 알파벳만 뽑아내기
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp))   answer = "YES";
        return answer;
    }
    public static void main(String[] args) {
        팰린드롬_replaceAll T = new 팰린드롬_replaceAll();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
