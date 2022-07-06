package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.util.Scanner;

public class 결정알고리즘me {
    public int count(int[] arr, int capacity){
        int sum = 0, count=1;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > capacity){
                count++;
                sum = arr[i];
            }
        }
        return count;
    }

    public int solution(int n, int m, int[] arr){
        int answer = 0, rt=0, lt=arr[arr.length-1];
        for(int x: arr) rt += x;

        while(lt <= rt){
            int capacity = (lt+rt) / 2;
            if(count(arr, capacity) <= m) {
                answer = capacity;
                rt = capacity -1;
            } else{
                lt = capacity+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        결정알고리즘me T = new 결정알고리즘me();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, m, arr));
    }
}
