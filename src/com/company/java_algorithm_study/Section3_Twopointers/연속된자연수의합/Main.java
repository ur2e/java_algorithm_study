package com.company.java_algorithm_study.Section3_Twopointers.연속된자연수의합;

import java.util.Scanner;

public class Main {
    private int solution(int n ){
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[n];
        for(int i = 0; i < m; i++) arr[i] = i+1;

        for(int rt = 0; rt < m; rt++){
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        //  연속된 자연수로 등장 가능한 수는
        // n / 2 + 1 까지이다. ex) 15 / 2 + 1 = 8.
        // 이 이후로는 무조건 n 을 넘게된다.

        // 연속 부분 수열의 합으로 생각해도 된다.
        // lt가 처음을 키고, rt를 더하고 증가시킨다. 그 다음, n과 같은지 확인한다.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
