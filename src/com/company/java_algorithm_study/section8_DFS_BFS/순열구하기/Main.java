package com.company.java_algorithm_study.section8_DFS_BFS.순열구하기;

import java.util.Scanner;

public class Main {
    static int[] pm;
    public void dfs(int L, int idx, int[] arr, int m){
        if(L == m)  {
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        else {
            for(int i = 0; i < arr.length; i++){
                if(idx != i){
                    pm[L] = arr[i];
                    dfs(L+1, i, arr, m);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        pm = new int[m];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // 맨 앞에 3, 6, 9 차례대로 박아
            pm[0] = arr[i];
            T.dfs(1, i, arr, m);
        }
    }
}
