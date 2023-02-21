package com.company.java_algorithm_study.Section1_String.암호;

import java.util.Scanner;

public class Main {
    private String solution(int n, String s){
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0'); // 0번째 문자부터 6번째 문자까지 자른다.

            // 2를 인자로 주면 2진수를 10진수로 바꾼다.
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s.substring(7); // 7번째문자 부터 끝까지 자른다.
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
