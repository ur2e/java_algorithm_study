package com.company.java_algorithm_study.String;

import java.util.Scanner;

public class 대소문자변환 {
    public String Solution(String str){
        StringBuilder answer = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) answer.append(Character.toLowerCase(c));
            else answer.append(Character.toUpperCase(c));
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        대소문자변환 T = new 대소문자변환();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
