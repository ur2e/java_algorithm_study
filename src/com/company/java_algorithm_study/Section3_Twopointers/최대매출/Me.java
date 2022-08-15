package com.company.java_algorithm_study.Section3_Twopointers.최대매출;

import java.io.*;
import java.util.*;

public class Me {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        int p1 = 0, p2 = k;
        int answer = sum;
        // 여기까지 세팅
        // p1 만큼 빼고, p2만큼 더해서 sum이랑 비교

        while(p2 < n){
            sum = sum - arr[p1] + arr[p2];
            if(sum > answer)    answer = sum;
            p1++; p2++;
        }
        System.out.println(answer);
    }
}
