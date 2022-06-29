package com.company.java_algorithm_study.Section7_Recursive;

public class 좋은피보나치_memoization {
    static int[] fibo;
    public int DFS(int n) {
        // 배열은 기본적으로 0으로 초기화된다.
        // memoization !
        if(fibo[n] > 0) return fibo[n];

        if (n == 1 || n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n-1) + DFS(n-2);
        }
    }

    public static void main(String[] args) {
        좋은피보나치_memoization T = new 좋은피보나치_memoization();
        int n = 45;
        // 인덱스 번호 1번부터 사용하기 위해 n+1 크기의 배열 생성
        // 기본으로 0으로 초기화되어 있다.
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 1 ; i <= 10; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
