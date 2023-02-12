package com.company.java_algorithm_study.Section1_String.팰린드롬;

import java.util.Scanner;

public class 팰린드롬_me_lt_rt {
    public String solution(String str) {
        String answer = "YES";
        int lt = 0;
        int rt = str.length()-1;
        str = str.toUpperCase();
        char[] arr = str.toCharArray();
        while(lt < rt) {
            if(!Character.isAlphabetic(arr[lt])) lt++;
            if(!Character.isAlphabetic(arr[rt])) rt--;
            if(Character.isAlphabetic(arr[lt]) && Character.isAlphabetic(arr[rt])) {
                if(arr[lt] != arr[rt]) return "NO";
                lt++; rt--;
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        팰린드롬_me_lt_rt T = new 팰린드롬_me_lt_rt();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));

    }
}
