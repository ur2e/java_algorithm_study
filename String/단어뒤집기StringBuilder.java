package com.company.java_algorithm_study.String;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기StringBuilder {
    public ArrayList<String> Solution(String[] str) {
        ArrayList<String> answer= new ArrayList<>();

        for(String s : str) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        단어뒤집기StringBuilder T = new 단어뒤집기StringBuilder();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strArr = new String[num];
        for(int i = 0 ; i < num; i++) {
            strArr[i] = sc.next();
        }
        for(String s: T.Solution(strArr)) {
            System.out.println(s);
        }
    }
}
