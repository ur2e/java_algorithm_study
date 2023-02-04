package com.company.java_algorithm_study.Section1_String.대소문자변환;

import java.util.Scanner;

public class Main {
    public String Solution(String str){
        StringBuilder answer = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) answer.append(Character.toLowerCase(c));
            else answer.append(Character.toUpperCase(c));
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
