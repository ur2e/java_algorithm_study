package com.company.java_algorithm_study.Section7_Recursive.DFS_부분집합구하기;

public class Main {
    static int n;
    static int[] ch;
    // L 원소를 사용한다 사용하지 않는다
    public void DFS(int L) {
        // 종착점
        if (L == n+1){
            String tmp = "";
            for(int i = 1; i <= n; i++){
                if(ch[i] == 1)  tmp += (i + "");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }
        else {
            ch[L] = 1;
            DFS(L+1); // 왼쪽으로 뻗기 (사용함)
            ch[L] = 0;
            DFS(L+1); // 오른쪽으로 뻗기 (사용하지 X)
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
