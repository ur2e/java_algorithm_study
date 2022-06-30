package com.company.java_algorithm_study.Section7_Recursive.경로탐색_인접리스트_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m, answer = 0;

    // Integer를 저장하는 ArrayList 객체를 저장하는 ArrayList를 선언
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else {
            // v번째 ArrayList
            for (int nv: graph.get(v)){
                // 방문했냐 안했냐
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();

        // 여기 중요 ! !
        // 정점의 갯수만큼 연결리스트 객체를 생성 (0은 안 씀)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 정점 번호가 1부터 시작하므로 n+1 크기만큼의 배열을 생성
        ch = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
    }
}
