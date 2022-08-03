package com.company.baekjoon.DFS_BFS.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int day;
    Node(int x, int y, int day){
        this.x = x;
        this.y= y;
        this.day = day;
    }
}
public class Main {
    static int n, m;
    static int[][] map;
    public static int bfs(){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] ch = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        // 시작할 토마토의 위치를 저장한다.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    q.offer(new Node(i ,j, 0));
                }
            }
        }

        int day = 0;
        while(!q.isEmpty()){
            Node c = q.poll();
            int cx = c.x;
            int cy = c.y;
            int cday = c.day;
            ch[cx][cy] = 1;
            if(cday > day)  day = cday;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 가보지 않은 곳이고,
                if(nx >=0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0 && map[nx][ny] == 0){
                    ch[nx][ny] = 1;
                    map[nx][ny] = 1;
                    q.offer(new Node(nx ,ny, cday+1));
                }
            }
        }
        return day;
    }

    public static void main(String[] args) throws IOException {
        // 1 익은 토마토
        // 0 익지 않은 토마토
        // -1 토마토가 들어있지 않은 칸

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = bfs();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0)  answer = -1;
            }
        }

        System.out.println(answer);
    }
}
