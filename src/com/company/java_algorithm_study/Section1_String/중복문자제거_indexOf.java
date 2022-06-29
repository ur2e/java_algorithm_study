package com.company.java_algorithm_study.Section1_String;

import java.util.Scanner;

public class 중복문자제거_indexOf {
    public String Solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i)+ " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i)) == i) {
                System.out.println();
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        중복문자제거_indexOf T = new 중복문자제거_indexOf();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
