package com.company.java_algorithm_study.Section1_String.팰린드롬;

import java.util.Scanner;

public class 팰린드롬_replaceAll {
    // 조건 : 특수문자를 제외한 알파벳만 회문 검사를 하고, 대소문자를 구분하지 않는다.

    // 따라서, (1) replaceAll()로 알파벳만 따로 모으고,
    // (2) StringBuilder.reverse(),
    // (3) equals() 메소드를 활용하자.
    public String solution(String str) {
        String answer = "NO";

        // (1) replaceAll()로 알파벳만 뽑아내기
        // replaceAll("[^A-Z]", "") : 알파벳 대문자가 아니면 ""로 대체해라
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
