package com.company.java_algorithm_study.Section2_Array;

import java.util.Scanner;

public class 피보나치수열_배열없이 {
    public void solution(int n){
        int a = 1; // idx 1
        int b = 1; // idx 2
        int temp;
        int answer = 0;
        System.out.print(a + " " + b);

        for(int i = 2; i < n; i++){
            answer = a + b;
            temp = b;
            b = answer;
            a = temp;
            System.out.print(answer + " ");
        }
    }

    public static void main(String[] args) {
        피보나치수열_배열없이 T = new 피보나치수열_배열없이();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        T.solution(n);
    }
}
