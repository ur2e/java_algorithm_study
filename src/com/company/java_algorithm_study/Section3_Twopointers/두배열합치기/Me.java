package com.company.java_algorithm_study.Section3_Twopointers.두배열합치기;

import java.util.Scanner;

public class Me {
    int[] solution(int[] a, int[] b, int n){
        int[] answer = new int[n];
        int x = 0;
        int y = 0;

        /**
         * x > a.length 아니고 x >= a.length 여야함..
         */
        for(int i = 0; i < n; i++){
            if(x >= a.length){
                answer[i] = b[y++];
            } else if(y >= b.length){
                answer[i] = a[x++];
            } else if (a[x] >= b[y]) {
                answer[i] = b[y++];
            } else if (a[x] < b[y]) {
                answer[i] = a[x++];
            }
        }
        return answer;

    }
    public static void main(String[] args){
        Me T = new Me();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

        int[] answer = T.solution(a, b, n+m);
        for(int x: answer){
            System.out.print(x + " ");
        }
    }
}
