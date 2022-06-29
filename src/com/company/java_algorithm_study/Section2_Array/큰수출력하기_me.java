package com.company.java_algorithm_study.Section2_Array;

import java.util.Scanner;

public class 큰수출력하기_me {
    public String solution(int[] arr){
        StringBuilder answer = new StringBuilder();

        answer.append(arr[0]).append(" ");

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]) answer.append(arr[i]).append(" ");
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        큰수출력하기_me T = new 큰수출력하기_me();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
