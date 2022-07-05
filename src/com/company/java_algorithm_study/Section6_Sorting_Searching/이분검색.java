package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int answer = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        /*
            이분 검색
         */
        int lt=0, rt=arr.length-1;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == num) {
                answer = mid+1;
                break;
            } else if (arr[mid] > num) rt = mid-1;
            else lt = mid+1;
        }
        System.out.println(answer);
    }
}
