package com.company.java_algorithm_study.section8_DFS_BFS.DFS_최대점수구하기;

import java.util.Scanner;

public class Me {
    static int n, m, answer = Integer.MIN_VALUE;
    static int[] score, time;
    static void dfs(int sIdx, int tIdx, int sSum, int tSum){
        if(tSum > m) return;
        if (n == sIdx) {
            answer = Math.max(answer, sSum);
        } else{
            dfs(sIdx+1, tIdx+1, sSum+score[sIdx], tSum+time[tIdx]);
            dfs(sIdx+1, tIdx+1, sSum, tSum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 문제 갯수
        m = sc.nextInt(); // 제한 시간

        score = new int[n];
        time = new int[n];

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            score[i] = a;
            time[i] = b;
        }
        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }
}
