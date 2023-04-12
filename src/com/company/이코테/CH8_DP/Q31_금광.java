package com.company.이코테.CH8_DP;

import java.util.Scanner;

public class Q31_금광 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int k = 0; k < T; k++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][m];
            int[][] d = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                    d[i][j] = map[i][j];
                }
            }

            for(int j = 1; j < m; j++){
                for(int i = 0; i < n; i++) {

                    d[i][j] = d[i][j - 1] + map[i][j];

                    if (i - 1 >= 0) {
                        d[i][j] = Math.max(d[i][j], d[i - 1][j - 1] + map[i][j]);
                    }

                    if (i + 1 < n) {
                        d[i][j] = Math.max(d[i][j], d[i + 1][j - 1] + map[i][j]);
                    }
                }
            }

            int answer = -1;
            for(int i = 0; i < n; i++){
                answer = Math.max(answer, d[i][m-1]);
            }
            System.out.println(answer);
        }
    }
}
/* map + map 이 아니라 dp + 맵 이어야지 바부양 ~ */
/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7

4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */