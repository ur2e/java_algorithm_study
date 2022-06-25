package com.company.java_algorithm_study.String;

import java.util.Scanner;

public class 단어뒤집기me {
    public String Solution(String str) {
        StringBuilder sb = new StringBuilder(str).reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        단어뒤집기me T = new 단어뒤집기me();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < num; i++) {
            String str = sc.nextLine();
            System.out.println(T.Solution(str));
        }

    }
}
