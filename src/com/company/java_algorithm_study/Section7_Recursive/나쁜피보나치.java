package com.company.java_algorithm_study.Section7_Recursive;

public class 나쁜피보나치 {
    public int DFS(int n) {
        if (n == 1 || n == 2) return 1;
        else {
            //System.out.print(n + " ");
            return DFS(n-1) + DFS(n-2);
        }
    }

    public static void main(String[] args) {
        나쁜피보나치 T = new 나쁜피보나치();
        int n = 10;
        for (int i = 1 ; i <= 10; i++) {
            System.out.print(T.DFS(i) + " ");
        }
    }
}
