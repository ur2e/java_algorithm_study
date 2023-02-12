package com.company.java_algorithm_study.Section1_String.회문문자열;

import java.util.Scanner;

public class Main {
    public String solution(String str) {

        /* 방법1. 문자열을 반으로 나누고 대칭인지 직접 확인하기 */
//        String answer = "YES";
//        int len = str.length(); // 문자열 길이가 홀수일때 정 가운데 위차한 글자는 대칭을 고려하지 않아도 된다.
//
//        for(int i = 0; i < len/2; i++) {
//            if(str.charAt(i) != str.charAt(len-i-1)){
//                return "NO";
//            }
//        }

        /* 방법2. StringBuilder().reverse() 할용하기*/
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
