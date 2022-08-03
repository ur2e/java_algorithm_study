package com.company.baekjoon.DFS_BFS.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] map, ch;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;

    public int bfs(int x, int y) {
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while(!q.isEmpty()) {
            Node c = q.poll();
            int cx = c.x;
            int cy = c.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && (map[nx][ny] == 1) && (ch[nx][ny] == 0)) {
                    count = count + 1;
                    ch[nx][ny] = 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        ch = new int[n][n];
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] in = br.readLine().split("");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    count++;
                    answer.add(T.bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(count);
        for(int x: answer){
            System.out.println(x);
        }
    }
}
