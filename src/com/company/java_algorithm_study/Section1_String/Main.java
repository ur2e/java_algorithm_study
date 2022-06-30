package com.company.java_algorithm_study.Section1_String;

import java.util.Scanner;

public class Main {
    public int solution(String str){
        int answer = 0;

        /* 방법 1 */
        for (char x : str.toCharArray()){
            if(x>=48 && x <=57) answer = answer * 10 + (x-48);
        }

        /* 방법 2 */
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)) answer += x;
        }

        /* 방법 3 */
        str = str.replaceAll("[^0-9]", "");

        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
