package com.company.java_algorithm_study.Section1_String.중복문자제거;

import java.util.Scanner;

public class 중복문자제거_indexOf {
    public String Solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            // 자기 위치(charAt())와 처음 발견된 위치(indexOf())가 다르면 중복 문자이다.
            System.out.println(str.charAt(i)+ " " + i + " " + str.indexOf(str.charAt(i)));

            // 자기 위치와 처음 발견된 위치가 같은 (= 중복 문자가 아닌) 문자만 출력한다.
            if(str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
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
