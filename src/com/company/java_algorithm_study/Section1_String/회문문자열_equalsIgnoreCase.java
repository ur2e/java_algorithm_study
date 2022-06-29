package com.company.java_algorithm_study.Section1_String;

import java.util.Scanner;

public class 회문문자열_equalsIgnoreCase {
    public String solution(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
    }
    public static void main(String[] args) {
        회문문자열_equalsIgnoreCase T = new 회문문자열_equalsIgnoreCase();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
