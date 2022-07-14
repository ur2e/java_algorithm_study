package com.company.baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식물피하기1743_이거다시보기 {
    static int[][] arr, check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, k;

    int dfs(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 갈 수 있는 좌표이고
            if(nx > 0 && nx <= n && ny > 0 && ny <= m){
                // 방문하지 않음 + 음쓰있는 곳
                if(check[nx][ny] == 0 && arr[nx][ny] == 1){
                    check[nx][ny] = 1;
                    count = dfs(nx, ny, count)+1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        음식물피하기1743_이거다시보기 T = new 음식물피하기1743_이거다시보기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        k = Integer.parseInt(st.nextToken()); // 음식물 개수
        int max = 0;

        arr = new int[102][102];
        check = new int[102][102];

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(check[i][j] == 0 && arr[i][j] == 1){
                    max = Math.max(T.dfs(i, j, 1), max);
                }
            }
        }

        System.out.println(max);
    }
}
