package com.company.baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기14503 {
    static int[][] map;
    static int y, x, answer;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0,-1}; // 북 동 남 서

    private static void dfs(int r, int c, int d){
        // 굳이 ch를 만들 필요 없구나~

        // 현재 위치를 청소한다.
        map[r][c] = -1;

        for(int i = 0; i < 4; i++){
            d = (d + 3) % 4;
            int ny = r + dy[d];
            int nx = c + dx[d];
            // 왼쪽으로 돌다가 청소할 곳 나오면 청소한다.
            if(ny >= 0 && ny < y && nx >= 0 && nx < x && map[ny][nx] == 0){
                answer++;
                dfs(ny, nx, d);
                return;
            }
            // 4방향 탐색끝났으면 후진
            int bd = (d + 2) % 4;
            int by = r + dy[bd];
            int bx = c + dx[bd];

            if(by >= 0 && by < y && bx >= 0 && bx < x && map[by][bx] != 1){
                dfs(by, bx, d);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        answer = 1;
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(answer);
    }
}
