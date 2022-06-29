package com.company.java_algorithm_study.Section7_Recursive;

public class 이진수출력_재귀 {
    public void DFS(int n) {
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.print(n % 2 + "");
        }
    }
    public static void main(String[] args) {
        이진수출력_재귀 T = new 이진수출력_재귀();
        T.DFS(11);
    }
}
