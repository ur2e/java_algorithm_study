package com.company.baekjoon.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int[][] ch = new int[15][15];
        int k, n;

        /* 모든 층 계산을 미리 해버리기*/
        for(int i = 1; i < 15; i++) {
            ch[0][i] = i;
            ch[i][1] = 1;
        }

        for(int i = 1; i <15; i++) {
            for(int j = 1; j < 15; j++){
                ch[i][j] = ch[i-1][j] + ch[i][j-1];
            }
        }

        for(int i=0; i < num; i++) {
            k = Integer.parseInt(br.readLine()); // k = 층
            n = Integer.parseInt(br.readLine()); // n = 호

            sb.append(ch[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
