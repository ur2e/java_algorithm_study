package com.company.baekjoon.이분탐색.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 정해진 총액 이하에서 가능한 최대의 총 예산
        // 모든 요청 배정 가능- > 그대로 배정
        // else 특정한 정수 상한액을 계산하여
        // 그 이상인 예산 요청에는 상한액을 배정

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] city = new int[n];

        for(int i = 0; i < n; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        long m = Integer.parseInt(br.readLine());

        int l = 0;
        int r = Arrays.stream(city).max().getAsInt();
        int answer = -1;
        while(l <= r){
            long sum = 0;
            int mid = (l + r) / 2;

            for(int i = 0; i < n; i++){
                if(mid >= city[i]) sum += city[i];
                else sum += mid;
            }

            if(sum > m) r = mid - 1;
            else if(sum < m) {
                answer = Math.max(mid, answer);
                l = mid + 1;
            } else {
                answer = mid;
                break;
            }
        }

        System.out.println(answer);
    }
}
