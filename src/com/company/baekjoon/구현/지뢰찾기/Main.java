package com.company.baekjoon.구현.지뢰찾기;

import java.io.*;

public class Main {
    // 상하좌우, 대각선 이동하면서 폭탄 있으면 1을 추가해

    static boolean[][] bomb, open;
    static int[][] map;
    static int n;

    void calBomb(int x, int y) {
        int[] dx = {1, -1 , 0 , 0, -1, -1, 1, 1};
        int[] dy = {0, 0 , 1 , -1, -1, 1, -1 ,1};

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 0 && nx <= n && ny > 0 && ny <= n && open[nx][ny]){
                map[nx][ny]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        bomb = new boolean[n+1][n+1];
        open = new boolean[n+1][n+1];
        map = new int[n+1][n+1];

        boolean flag = false;

        // 지뢰위치
        for(int i = 1; i <= n; i++){
            char[] in = br.readLine().toCharArray();
            for(int j = 1; j <= n; j++){
                // 지뢰 X
                 if (in[j-1] == '.'){
                     bomb[i][j] = false;
                 } else {
                     bomb[i][j] = true;
                 }
             }
        }

        // 열린 칸
        for(int i = 1; i <= n; i++){
            char[] in = br.readLine().toCharArray();
            for(int j = 1; j <= n; j++){
                if (in[j-1] == '.'){
                    open[i][j] = false;
                } else {
                    open[i][j] = true;
                    if(bomb[i][j])  flag = true;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (bomb[i][j]) {
                    T.calBomb(i, j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(flag && bomb[i][j]) bw.write("*");
                else if (!open[i][j]) bw.write(".");
                else bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
