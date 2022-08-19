package com.company.java_algorithm_study.Section3_투포인터.연속된자연수의합;

import java.util.Scanner;

public class Me {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 크면 뺴고, 작으면 더해
        int p1 = 1, p2 = 3, sum = 1 + 2, answer = 0;
        while(p2 < n){
            if(sum == n){
                answer++;
                sum = sum +  p2++ - p1++;
            } else if(sum < n) {
                sum += p2++;
            } else {
                sum -= p1++;
            }
        }
        System.out.println(answer);
    }
}
