package com.company.baekjoon.DFS_BFS.숨바꼭질4;

import java.io.*;
import java.util.*;

class Node {
    int x;
    int sec;
    Node prev;

    public Node (int x, int sec){
        this.x = x;
        this.sec = sec;
    }

}
public class Main {
    static int MAX_VALUE = 100000;
    private String bfs(int n, int k){
        StringBuilder answer = new StringBuilder();

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(n, 0));
        while(!q.isEmpty()){
            Node c = q.poll();
            int cx = c.x;
            int csec = c.sec;

            if(cx == k) {
                answer.append(csec).append("\n");
                break;
            }

            if(cx - 1 > 0) {
                Node next = new Node(cx - 1, csec + 1);
                q.offer(next);
                next.prev = c;

            }
            if(cx + 1 < MAX_VALUE) {
                Node next = new Node(cx + 1, csec + 1);
                q.offer(next);
                next.prev = c;
            }
            if(cx * 2 < MAX_VALUE) {
                Node next = new Node(cx * 2, csec + 1);
                q.offer(next);
                next.prev = c;
            }
        }
        return answer.toString().trim();
    }
    public static void main(String[] args) throws IOException{
        /*
            1초 후 : x-1, x+1, 2*X
         */
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(T.bfs(n, k));
    }
}
