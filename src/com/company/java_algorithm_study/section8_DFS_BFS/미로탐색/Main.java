package com.company.java_algorithm_study.section8_DFS_BFS.미로탐색;

import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static int[][] map, ch;

    static void dfs(int x, int y){
        if(x==7 && y ==7) {
            count++;
            return;
        }
        else {
            for(int i = 0; i < 4; i ++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx <= 7 && nx > 0 && ny <= 7 && ny >0){
                    // 갈 수 있는 길
                    if(ch[nx][ny] == 0 && map[nx][ny] == 0){
                        ch[nx][ny] = 1;
                        dfs(nx, ny);
                        ch[nx][ny] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        map = new int[8][8];
        ch = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        ch[1][1] = 1;
        dfs(1, 1);
        System.out.println(count);
    }
}
