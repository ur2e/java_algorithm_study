package com.company.baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전쟁_전투_1303 {
    static boolean[][] arr;
    static int[][] check = new int[101][101];
    static int n, m;
    static int dx[] = {0, 0, -1, 1}; // 상 하 좌 우
    static int dy[] = {-1, 1, 0, 0}; // 상 하 좌 우

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int BFS(int x, int y, boolean isWhite){
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        check[x][y] = 1;
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node cv = q.poll(); // 현재 상태
            for (int i = 0; i < 4; i++) {
                int nx = cv.x + dx[i];
                int ny = cv.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    // 같다면
                    if (check[nx][ny] == 0 && isWhite == arr[nx][ny]) {
                        count++;
                        check[nx][ny] = 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[m][n];
        boolean white = true;

        for(int i = 0 ; i < m; i++) {
            int j = 0;
            for (char x : br.readLine().toCharArray()) {
                if (x == 'W') arr[i][j] = true;
                else arr[i][j] = false;
                j++;
            }
        }

        int sumW = 0, sumB = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(check[i][j] == 0) {
                    if(arr[i][j]) {
                        int num = BFS(i, j, true);
                        sumW += num * num;
                    }
                    else {
                        int num = BFS(i, j, false);
                        sumB += num * num;
                    }
                }
            }
        }

        System.out.println(sumW + " " + sumB);
    }
}
