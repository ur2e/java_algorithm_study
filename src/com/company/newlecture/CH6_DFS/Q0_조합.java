package com.company.newlecture.CH6_DFS;

import java.util.Scanner;

public class Q0_조합 {
    static int[] combi, arr, ch;
    static int n, m;
    static int num = 1;

    /* 조합은 탐색 시작 순서를 저장할 변수를 하나 더 만들자*/

    // 선생님 풀이
    private static void dfs(int L, int s){
        if(L == m) {
            for(int x: combi)  System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                if(ch[i] == 0) {
                    combi[L] = i;
                    dfs(L+1, s+1);
                }
            }
            num++;
        }
    }
    // 내 풀이 num 변수를 두기
//    private static void dfs(int L){
//        if(L == m) {
//            for(int x: combi)  System.out.print(x + " ");
//            System.out.println();
//        } else {
//            for(int i = num; i <= n; i++) {
//                if(ch[i] == 0) {
//                    combi[L] = i;
//                    ch[i] = 1;
//                    dfs(L+1);
//                    ch[i] = 0; // dfs BACK 하고 체크배열 해제
//                }
//            }
//            num++;
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        ch = new int[n+1];

        dfs(0, 1);
    }
}
