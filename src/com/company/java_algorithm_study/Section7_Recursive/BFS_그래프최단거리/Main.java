package com.company.java_algorithm_study.Section7_Recursive.BFS_그래프최단거리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0; // 출발 지점 -> 0으로
        queue.offer(v);
        while(!queue.isEmpty()) {
            // current vertex
            int cv = queue.poll();
            // cv(현재정점)에서 갈 수 있는 정점들을 탐색
            for(int nv : graph.get(cv)){
                // 가보지 않은 정점이라면
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                    int i = 1;
                    for(int x : dis) {
                        System.out.print( x+ " ");
                        i++;

                    }
                    System.out.println();
                }
            }
        }


    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();

        // 정점 갯수만큼 인접리스트 객체 생성
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ch = new int[n+1];
        dis = new int[n+1];

        for(int i = 0; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        T.BFS(1);
        for(int i=2 ; i<= n; i++) {
            System.out.println(i + " " + dis[i]);
        }

    }
}
