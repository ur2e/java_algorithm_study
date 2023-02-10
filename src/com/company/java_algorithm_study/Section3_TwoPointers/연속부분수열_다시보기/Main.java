package com.company.java_algorithm_study.Section3_TwoPointers.연속부분수열_다시보기;

import java.util.Scanner;

public class Main {
    private int solution(int n, int m, int[] arr){
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < n; rt++){
            sum += arr[rt]; // sum은 lt부터 rt까지의 합
            if(sum == m) answer++;
            while(sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
