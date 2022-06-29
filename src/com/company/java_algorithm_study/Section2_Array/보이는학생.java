package com.company.java_algorithm_study.Section2_Array;

import java.util.Scanner;

public class 보이는학생 {
    public int solution(int[] arr){
        int answer = 1; // 첫 번째 사람은 무조건 보이니까
        int max = arr[0];
        for(int i : arr){
            if( i > max) {
                answer++;
                max = i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        보이는학생 T = new 보이는학생();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
