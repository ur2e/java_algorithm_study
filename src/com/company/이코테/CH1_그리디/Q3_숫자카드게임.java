package com.company.이코테.CH1_그리디;

import java.util.Scanner;

public class Q3_숫자카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] card = new int[n][m];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                card[i][j] = sc.nextInt();
                min = Math.min(card[i][j], min);
            }
            max = Math.max(max, min);
        }
        System.out.println(max);
    }
}
/*
3 3
3 1 2
4 1 4
2 2 2

-> 2

2 4
7 3 1 8
3 3 3 4

-> 3
 */