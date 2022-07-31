package com.company.baekjoon;

import java.util.Scanner;

public class 수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long sum = 0;
        long i = 0;

        while(true){
            i++;
            sum += i;
            if(sum > n) break;
        }
        System.out.println(i-1);

    }
}
