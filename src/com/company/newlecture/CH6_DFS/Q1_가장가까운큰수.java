package com.company.newlecture.CH6_DFS;

import java.util.Arrays;

public class Q1_가장가까운큰수 {
    static int[] arr, ch;
    static int N, pivot, answer; // pivot 대신 target

    private void bfs(int L, int num){
        if(L == N) {
            if (num > pivot) {
                answer = Math.min(answer, num);
                return;
            }
        }
        else {
            for(int i = 0; i < N; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    bfs(L+1, num * 10 + arr[i]);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n){
        String num = String.valueOf(n);
        N = num.length();
        arr = new int[N];
        ch = new int[N];
        pivot = n;
        answer =Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = num.charAt(i) - '0';
        }
        Arrays.sort(arr);

        bfs(0, 0);

        return answer = answer == Integer.MAX_VALUE? -1 : answer;
    }

    public static void main(String[] args){
        Q1_가장가까운큰수 T = new Q1_가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
