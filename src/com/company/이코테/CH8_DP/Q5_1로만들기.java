package com.company.이코테.CH8_DP;

import java.util.Scanner;

public class Q5_1로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int answer = 0;

        if(n == 1)  answer = 0;
        else if (n < 4)    answer = 1;
        else {
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;

            if(n >= 5)  dp[5] = 1;

            for(int i = 4; i <= n; i++){
                //int min = Integer.MAX_VALUE; // 이거 두지말고
                dp[i] = dp[i-1] + 1; // 이건 무조건 있으니까..

                if(i % 5 == 0) {
                    //min = Math.min(min, dp[i/5]);
                    dp[i] = Math.min(dp[i], dp[i/5] + 1);
                }

                if(i % 3 == 0) {
                    //min = Math.min(min, dp[i/3]);
                    dp[i] = Math.min(dp[i], dp[i/3] + 1);
                }

                if(i % 2 == 0) {
                    //min = Math.min(min, dp[i/2]);
                    dp[i] = Math.min(dp[i], dp[i/2] + 1);
                }
            }

            answer = dp[n];
        }

        System.out.println(answer);
    }
}
