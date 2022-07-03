package com.company.baekjoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_1260 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int n;

    static void DFS(int v) {
        for(int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                System.out.print(nv + " ");
                DFS(nv);
            }
        }
    }

    static void BFS(int v) {
        // 방문하지 않은 점이라면
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        q.offer(v);
        while(!q.isEmpty()){
            int cv = q.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    q.offer(nv);
                    System.out.print(nv + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        // 정점 갯수만큼 인접리스트 객체 생성
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ch = new int[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        System.out.print(v + " ");
        ch[v] = 1;
        DFS(v);

        System.out.println();

        for(int i = 0; i <=n; i++){
            ch[i] = 0;
        }
        System.out.print(v + " ");
        BFS(v);

    }
}
