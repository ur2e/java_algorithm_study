package com.company.java_algorithm_study.Section7_Recursive.DFS_경로탐색;

import java.util.Scanner;


public class Main {
    static int N, M, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v){
        // 마지막 노드면 경로 1 증가
        if(v == N)  answer++;
        // 아니라면 계속 뻗어 나가자
        else {
            for(int i = 1; i <= N; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0; // 탐색 끝나고 나올 때 체크 풀어주기
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점
        int M = sc.nextInt(); // 간선

        graph = new int[N+1][N+1];
        ch = new int[N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
