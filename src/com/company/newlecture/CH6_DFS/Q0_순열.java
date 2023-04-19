package com.company.newlecture.CH6_DFS;

import java.util.Scanner;

public class Q0_순열 {
    // 중복 X 순열이라면
    // CH  배열을 생성하자~
    static int[] pm, arr, ch;
    static int n, m;
    private static void dfs(int L){
        if(L == m) {
            for(int x: pm)  System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    dfs(L+1);
                    ch[i] = 0; // dfs BACK 하고 체크배열 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        pm = new int[m];

        dfs(0);
    }
}
