package com.company.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static boolean[] visited;
    static int k, answer=Integer.MAX_VALUE, minTime;
    final static int MAX = 100000;
    static int[] ans;
    static boolean flag = false;

    static class Pos {
        int x, L;
        Pos(int x, int L){
            this.x = x;
            this.L = L;
        }
    }

    static private int bfs(int x){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, 0));

        while(!q.isEmpty()){
            Pos curr = q.poll();
            visited[curr.x] = true;
            if(curr.L > answer)     break;

            int nx = curr.x * 2;
            if(nx == k) return curr.L + 1;
            if(nx <= MAX && !visited[nx])   {
                q.offer(new Pos(nx, curr.L+1));
            }

            nx = curr.x + 1;
            if(nx == k) return curr.L + 1;
            if(nx <= MAX && !visited[nx])   {
                q.offer(new Pos(nx, curr.L+1));
            }

            nx = curr.x - 1;
            if(nx == k) return curr.L + 1;
            if(nx >=0  && !visited[nx])   {
                q.offer(new Pos(nx, curr.L+1));
            }
        }
        return -1;
    }

    static void dfs(int x, int L){
        if(flag) return;

        if( L > minTime) return;

        if(L == minTime) {
            if(x == k) {
                ans[L] = k;
                flag = true;
            }
        } else {
            ans[L] = x;
            if(!flag) dfs(x*2, L+1);
            if(!flag) dfs(x+1, L+1);
            if(!flag) dfs(x-1, L+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];

        minTime = n == k? 0 : bfs(n);
        ans = new int[minTime+1];
        dfs(n, 0);

        StringBuilder sb = new StringBuilder();
        for(int num: ans){
            sb.append(num).append(" ");
        }

        System.out.println(minTime);
        System.out.println(sb.toString().trim());
    }
}
