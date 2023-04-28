package com.company.이코테.CH1_그리디;

import java.util.Scanner;

public class Q5_볼링공고르기 {

    private static void dfs(int x){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = 0;
        int[] ball = new int[n];
        for (int i = 0; i < n; i++) {
            ball[i] = sc.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(ball[i] != ball[j])  answer++;
            }
        }

        System.out.println(answer);
    }
}
/*
5 3
1 3 2 3 2

8 5
1 5 4 3 2 4 5 2

* */