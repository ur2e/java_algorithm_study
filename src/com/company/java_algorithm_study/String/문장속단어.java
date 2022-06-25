package com.company.java_algorithm_study.String;

import java.util.Scanner;

public class 문장속단어 {
    public String Solution(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;

        String[] strArr = str.split(" ");
        for(String s : strArr) {
            if(s.length() > max){
                max = s.length();
                answer = s;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        문장속단어 T = new 문장속단어();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
