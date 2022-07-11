package com.company.java_algorithm_study.section8_DFS_BFS.순열구하기;

import java.util.Scanner;

public class Main {
    public void dfs(int L, int[] arr, int n){
        if(L == n)  return;
        else {
            
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        dfs(0, arr, n);

    }
}
