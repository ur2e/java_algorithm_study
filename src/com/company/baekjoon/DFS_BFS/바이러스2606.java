package com.company.baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, check;
    // 1번을 루트로해서 모든 경로 탐색하기 ~ ~
    public void DFS(int v){
        // 1번이 연결리스트를 탐색합니당
        for(int nv: graph.get(v)){
            if(ch[nv] == 0){
                ch[nv] = 1;
                check[nv] = 1;
                DFS(nv);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        바이러스2606 T = new 바이러스2606();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 0;
        graph = new ArrayList<ArrayList<Integer>>();

        // 여기 중요 ! !
        // 정점의 갯수만큼 연결리스트 객체를 생성 (0은 안 씀)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 연결 만들고
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch = new int[n+1];
        check = new int[n+1];
        ch[1] = 1;

        T.DFS(1);
        for(int x: check) {
            if(x == 1) answer++;
        }
        System.out.println(answer);
    }
}
