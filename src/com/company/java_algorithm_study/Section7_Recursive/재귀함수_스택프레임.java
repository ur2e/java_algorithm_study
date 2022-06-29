package com.company.java_algorithm_study.Section7_Recursive;

public class 재귀함수_스택프레임 {
    public void DFS(int n) {
        if(n == 0) return;
        else {
            //System.out.print(n + ""); // 3 2 1
            DFS(n-1);
            System.out.print(n + " "); // 1 2 3
        }

    }
    public static void main(String[] args) {
        재귀함수_스택프레임 T = new 재귀함수_스택프레임();
        T.DFS(3);
    }
}
