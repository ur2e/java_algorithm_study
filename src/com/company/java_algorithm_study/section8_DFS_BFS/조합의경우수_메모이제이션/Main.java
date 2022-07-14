package com.company.java_algorithm_study.section8_DFS_BFS.조합의경우수_메모이제이션;

import java.util.Scanner;

public class Main {
    static int[][] combi;
    static int dfs(int n, int r){
        if(combi[n][r] != 0) return combi[n][r];
        if(r == 1 || n - r == 1)  return n;
        if(r == 0 || n == r)  return 1;
        else {
            return combi[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        combi = new int[n+1][r+1];
        System.out.println(dfs(n, r));
    }
}
