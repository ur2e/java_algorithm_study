package com.company.java_algorithm_study.section8_DFS_BFS.DFS_바둑이승차;

import java.util.Scanner;

public class Me {
    // limit(c)는 항상 같으니까 그냥 staic으로 두자
    static int n, answer = 0;
    static void dfs(int idx, int sum, int limit, int[] arr){
        if(sum >= limit) return;
        // 마지막 바둑이라면 종료
        if(idx == n) {
            answer = Math.max(answer, sum);
            return ; // 이걸 왜 쓴거지 ? !
        }
        else {
            dfs(idx+1, sum+arr[idx], limit, arr);
            dfs(idx+1, sum, limit, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // sum도 계속 넘거줄거니까 main 함수에서 다로 선언할 필요 없었다 ~
        int sum = 0;
        dfs(0, sum, c, arr);

        System.out.println(answer);
    }
}
