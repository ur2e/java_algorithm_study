package com.company.java_algorithm_study.Section1_String.문장속단어;

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "";
        String[] strArr = str.split(" ");

        int max = 0;
        for(String s: strArr){
            if(s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
