package com.company.newlecture.CH7.미로의최단거리통로4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] visited;
    static int[][] map;
    static int[] ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static private class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static private int bfs(){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0));
        int L = 0;

        while(!q.isEmpty()){
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Pos curr = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = curr.x + dx[j];
                    int ny = curr.y + dy[j];

                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && map[nx][ny] == 0 && visited[nx][ny] == 0){
                        if(nx == 6 && ny == 6) return L+1;
                        visited[nx][ny] = 1;
                        //System.out.println(nx + " " +ny);
                        q.offer(new Pos(nx, ny));
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new int[7][7];
        map = new int[7][7];

        for (int i = 0; i < 7; i++) {
            String str = br.readLine();
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        System.out.println(bfs());
    }
}
/*
0000000
0111111
0001000
1101011
1101000
1000100
1010000

0000000
0111110
0001000
1101111
1101000
1000100
1010100
 */
