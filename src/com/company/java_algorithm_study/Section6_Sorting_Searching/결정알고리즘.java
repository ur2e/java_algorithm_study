package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class 결정알고리즘 {
    public int count(int[] arr, int capacity){
        int cnt = 1, sum=0;
        for(int x: arr){
            if(sum + x > capacity){
                cnt++;
                sum = x;
            }
            else sum += x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr){
        int answer = 0;

        // stream으로 빠르게 최댓값과 합계 구하기
        int lt = Arrays.stream(arr).max().getAsInt(); // 노래 곡들 중 최대값
        int rt = Arrays.stream(arr).sum();

        // 이분검색 시작
        while(lt <= rt){
            int mid = (lt+rt) / 2;
            if(count(arr, mid) <= m){
                answer = mid;
                rt = mid-1;
            }
            else lt = mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        결정알고리즘 T = new 결정알고리즘();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, m, arr));
    }
}
