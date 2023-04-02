package com.company.이코테.CH8_DP;

import java.util.Scanner;

public class Q6_개미전사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] food = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            food[i] = sc.nextInt();
        }

        dp[1] = food[1];
        // dp[2] = food[2]; -> 이거 아니지~~~~~ food 1이 더 크면 어쩔 껀데 ~
        dp[2] = Math.max(food[0], food[1]);
        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i - 2] + food[i], dp[i - 1]);
        }

        // System.out.println(Math.max(dp[n-1], dp[n]));
        // 왜 또 max를 따져~~
        // dp 에는 계속 제일 큰 값만 저장을 했잖니~
        System.out.println(dp[n]);
    }
}
