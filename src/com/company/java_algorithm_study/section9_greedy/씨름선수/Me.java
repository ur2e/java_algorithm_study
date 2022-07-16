package com.company.java_algorithm_study.section9_greedy.씨름선수;

import java.util.Scanner;

public class Me {
    public static void main(String[] args) {
        Me T = new Me();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 비교 시작
        int answer = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++) {
                if( arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] ) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
