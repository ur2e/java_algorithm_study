package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기1018 {
    static boolean[][] board;
    static int check = 0;
    static boolean color;
    public int solution(int n, int m) {
        for(int i = n; i <= n+7; i++) {
            for(int j = m; j <= m+7; j++) {
                if( board[i][j] != color ) {
                    check++;
                    //System.out.println(i + " " + j);
                }
                color = !color;
            }
            color = !color;
        }
        return Math.min(check, 64-check);
    }

    public static void main(String[] args) throws IOException {
        체스판다시칠하기1018 T = new 체스판다시칠하기1018();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        String s;

        // 값 받아와서 tf 형태로 바꾸기
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++){
               if( str[j].equals("W"))   board[i][j] = true;
               else board[i][j] = false;
            }
        }

        // m-7, n-7 번만큼 이동해야함
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-7; i++) {
            for(int j = 0; j < m-7; j++) {
                color = board[i][j];
                int c = T.solution(i, j);
                //System.out.println(i + " " +j +" "+c);
                check = 0;
                if ( min > c) min = c;
            }
        }
        System.out.println(min);
    }
}
