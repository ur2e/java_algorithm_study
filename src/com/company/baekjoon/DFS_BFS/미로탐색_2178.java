package com.company.baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
    static char[][] map;
    static int[][] check;
    static int n ,m;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static class Node {
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        while(!q.isEmpty()){
            Node cv = q.poll();
            if(cv.x == n-1 && cv.y == m-1){
                return cv.count;
            }
            for(int i = 0; i < 4; i++){
                int nx = cv.x + dx[i];
                int ny = cv.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (check[nx][ny] == 0 && map[nx][ny] == '1') {
                        check[nx][ny] = 1;
                        int count = cv.count + 1;
                        q.offer(new Node(nx, ny, count));
                    }
                }
            }
        }
        return 0;
    }

//    static void dfs(int x, int y, int count){
//        if(x == n-1 && y == m-1) {
//            answer = Math.min(answer, count);
//            return ;
//        }
//        for(int i = 0; i < 4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                if (check[nx][ny] == 0 && map[nx][ny] == '1') {
//                    temp[nx][ny] = 1;
//                    check[nx][ny] = 1;
//                    count++;
//                    for (int k = 0; k < n; k++) {
//                        for (int j = 0; j < m; j++) {
//                            System.out.print(temp[k][j] + " ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("---------------------------------------");
//                    dfs(nx, ny, count);
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        check = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            for(char c : st.nextToken().toCharArray()) {
                map[i][j] = c;
                j++;
            }
        }

        check[0][0] = 1;
        System.out.println(bfs());
    }
}
