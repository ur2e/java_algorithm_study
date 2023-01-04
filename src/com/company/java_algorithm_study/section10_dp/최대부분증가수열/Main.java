package com.company.java_algorithm_study.section10_dp.최대부분증가수열;

import java.util.Scanner;

public class Main {
    static int[] dy;
    public int solution(int[] arr){
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1; // arr[0]까지의 최대부분증가수열 최대길이는 1
        for(int i=1; i < arr.length; i++){
            int max = 0;
            for(int j = i-1; j >= 0 ; j--) {
                if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max+1;
            answer = Math.max(answer, dy[i]); // for문 다 끝나고 answer 찾지말고 바로 바로 찾으면 된다.
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
