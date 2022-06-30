package com.company.java_algorithm_study.Section7_Recursive.BFS_송아지찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1; // 출발지점
        Q.offer(s);
        int L = 0; // level : 루트노드는 레벨이 0
        while(!Q.isEmpty()){
            int len = Q.size(); // 처음엔 1
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for( int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if( nx == e ) return L + 1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));

    }
}


