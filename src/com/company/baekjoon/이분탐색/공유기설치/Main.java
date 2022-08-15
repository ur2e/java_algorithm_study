package com.company.baekjoon.이분탐색.공유기설치;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MIN_VALUE;
        Arrays.sort(house);
        int lt = 0;
        int rt = Arrays.stream(house).max().getAsInt();
        
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1;
            int end = house[0];

            for(int i = 1; i < n; i++){
                if(house[i] - end >= mid) {
                    cnt++;
                    end = house[i];
                }
            }

            // 가진 공유기 갯수보다 설치할 수 있는 공유기가 많다 => 범위를 좁힌다.
            if(cnt >= c) {
                lt = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
