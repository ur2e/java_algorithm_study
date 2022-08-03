package com.company.java_algorithm_study.section9_greedy.회의실배정;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i]= sc.nextInt();
            end[i] = sc.nextInt();
        }

        // 빨리 끝나는 애들부터 처리한다
        for(int i = 0; i < n; i++){

        }
    }
}
