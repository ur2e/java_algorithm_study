package com.company.java_algorithm_study.section8_DFS_BFS.미로의최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x;
    int y;
    int count;
    Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] ch, arr;

    public int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));

        while(!q.isEmpty()){
            Node cnode = q.poll();
            int cx = cnode.x;
            int cy = cnode.y;
            int ccount = cnode.count;

            if(cx == 7 && cy == 7) return ccount;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int ncount = ccount + 1;

                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && ch[nx][ny] == 0 && arr[nx][ny] == 0){
                    ch[nx][ny] = 1;
                    q.offer(new Node(nx, ny, ncount));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        arr = new int[8][8];
        ch = new int[8][8];

        for(int i=1; i <= 7; i++){
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //T.bfs(0,0);
        ch[1][1] =1;
        System.out.println(T.bfs(1,1));

    }

}
