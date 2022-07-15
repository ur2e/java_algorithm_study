package com.company.baekjoon.DFS_BFS.숨바꼭질2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static class Node{
        int x;
        int L;

        Node (int x, int L){
            this.x = x;
            this.L = L;
        }
    }
    static int[] ch = new int[100001];
    static int answer  = Integer.MAX_VALUE;
    static int same_time_answer = 0;
    static int[] move = {1, -1, 2};

    static void bfs(int L, int n, int k){
        if(n == k) {
            answer = 0;
            same_time_answer = 1;
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        ch[n] = 1;
        q.add(new Node(n, L));

        while(!q.isEmpty()){
            Node cnode = q.poll();
            int cx = cnode.x;
            int cL = cnode.L;
            ch[cx] = 1;
            int nx = -1;
            if(cL >= answer) continue;
            for (int i = 0; i < 3; i++) {
                if(move[i] == 1) {
                    nx = cx + 1;
                } else if(move[i] == -1){
                    nx = cx - 1;
                } else {
                    nx = cx * 2;
                }

                if( nx == k ) {
                    answer = Math.min(answer, cL + 1);
                    if(cL + 1 == answer && ch[nx] == 0){
                        same_time_answer = same_time_answer+1;
                    }
                    continue;
                }

                if (nx <= 100000 && nx >= 0 && cL < answer && ch[nx] == 0) {
                    q.add(new Node(nx, cL + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ch[n] = 0;
        bfs(0, n, k);
        System.out.println(answer);
        System.out.println(same_time_answer);
    }
}
