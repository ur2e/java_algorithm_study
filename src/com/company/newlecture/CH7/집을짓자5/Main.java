package com.company.newlecture.CH7.집을짓자5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map, visited, dist, check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static private class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static private void bfs(Pos pos, int m){
        boolean chekoMove = false;
        Queue<Pos> q = new LinkedList<>();
        q.offer(pos);
        int L = 0;

        while(!q.isEmpty()){
            int n = q.size();
            L++;
            for (int i = 0; i < n; i++) {
                Pos curr = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = curr.x + dx[j];
                    int ny = curr.y + dy[j];

                    if(nx >= 0 && nx < m && ny >= 0 && ny < m && map[nx][ny] == 0 && visited[nx][ny] == 0 && check[nx][ny] != -1){
                        //enableMove = true;
                        visited[nx][ny] = 1;
                        dist[nx][ny] += L;
                        q.offer(new Pos(nx, ny));
                    }
                }
            }
        }
        // visited 체크해서 못 간 블록은 쳐다보지마
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] == 0) {check[i][j] = -1;}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new int[n][n];
        map = new int[n][n];
        dist = new int[n][n];
        check = new int[n][n];

        int building = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                if(map[i][j] == 2)  building++;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    bfs(new Pos(i, j), n);
                    visited = new int[n][n];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0 && check[i][j] != -1){
                    min = Math.min(dist[i][j], min);
                }
            }
        }

        min = min == Integer.MAX_VALUE? -1: min;
        System.out.println(min);


    }
}
/*
5
10201
00000
02100
20022
00000


4
1001
0020
0010
2200

4
1200
0012
0200
0210

4
1001
0020
0010
2201
 */