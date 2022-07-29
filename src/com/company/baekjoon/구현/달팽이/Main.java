package com.company.baekjoon.구현.달팽이;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n+1][n+1];

        int x = n/2, y = n/2;
        board[x][y] = 1;
        int num  = 3;
        int start = 1;
        int answerX = 0, answerY = 0;

        while(num <= n){
            int value = start+1;
            int cnt = 1;
            x -= 1;
            y -= 1;

            // 오른쪽
            /**
             *  이거 for문으로 ... 하면 cnt++ 따로 안해도 되고, 초기화도 안해줘도 되자너
             */
            while(cnt <= num-1) {
                board[x][++y] = value++;
                cnt++;
            }

            // 아래
            cnt = 1;
            while(cnt <= num-1) {
                board[++x][y] = value++;
                cnt++;
            }

            // 왼쪽
            cnt = 1;
            while(cnt <= num-1) {
                board[x][--y] = value++;
                cnt++;
            }

            //위
            cnt = 1;
            while(cnt <= num-1) {
                board[--x][y] = value++;
                cnt++;
            }

            num += 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( board[i][j] == k ) {
                    answerX = i;
                    answerY = j;
                }
                bw.write(board[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write((answerX +1) +" " + (answerY +1));
        bw.flush();
    }
}



