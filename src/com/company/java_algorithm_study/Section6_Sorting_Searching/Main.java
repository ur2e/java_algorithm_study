package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];

        // 기준 : 두 말 사이의 거리
        int lt = 1; // 최소거리
        int rt = arr[n - 1]; // 최대거리

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
