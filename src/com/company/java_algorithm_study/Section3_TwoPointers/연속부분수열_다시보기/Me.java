package com.company.java_algorithm_study.Section3_TwoPointers.연속부분수열_다시보기;

import java.util.Scanner;

public class Me {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt = 0; rt <n ; rt++){
            sum += arr[rt];
            if(sum == m) {
                answer++;
                sum -= arr[lt++]; // 어짜피 rt가 계속증가해서 커지니까 이 문장 없어도 된다.
            } else if(sum > m) {
                while(sum > m){
                    sum -= arr[lt++];
                }
            }
        }
        System.out.println(answer);
    }
}