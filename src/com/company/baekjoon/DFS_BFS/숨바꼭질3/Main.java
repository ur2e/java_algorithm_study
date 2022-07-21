package com.company.baekjoon.DFS_BFS.숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] ch;
    static int n, k, answer = Integer.MAX_VALUE;

    class Node{
        int x;
        int L;
        Node(int x, int L){
            this.x = x;
            this.L = L;
        }
    }
    void bfs(int x){

        Queue<Node> q = new LinkedList<>();
        ch[x] = 1;
        q.offer(new Node(x, 0));

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.L > answer) return;
            if(curr.x == k) {
                answer = Math.min(curr.L, answer);
            }
            else {
                int nx = curr.x * 2;
                if( nx <= 100000 && ch[nx] == 0){
                    q.offer(new Node(nx, curr.L));
                }
                ch[curr.x] = 1;
                nx = curr.x - 1;
                if( nx >= 0 && ch[nx] == 0){
                    q.offer(new Node(nx, curr.L + 1));
                }
                nx = curr.x + 1;
                if( nx <= 100000 && ch[nx] == 0){
                    q.offer(new Node(nx, curr.L + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ch = new int[100001];

        T.bfs(n);
        System.out.println(answer);
    }
}
