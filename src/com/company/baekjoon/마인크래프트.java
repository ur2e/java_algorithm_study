package com.company.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); // 블록 갯수

        int[][] arr = new int[n][m];

        // 배열초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, Arrays.stream(arr[i]).min().getAsInt());
            max = Math.max(max, Arrays.stream(arr[i]).max().getAsInt());
        }

        int ansTime = Integer.MAX_VALUE, ansHeight = Integer.MIN_VALUE;

        for(int h = min; h <= max; h++){
            int add = 0, remove = 0, time = 0;
            int tmpBlock = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 높이가 더 낮아.
                    if(h > arr[i][j]) add += h - arr[i][j];
                    else if(h < arr[i][j]) {
                        remove += arr[i][j] - h;
                        tmpBlock += arr[i][j] - h;
                    }
                }
            }

            if(add > tmpBlock) continue;
            else {
                time = time + add + (2 * remove);
            }

            if(ansTime > time){
                ansTime = time;
                ansHeight = h;
            } else if(ansTime == time){
                ansHeight = Math.max(h, ansHeight);
            }
        }
        System.out.println(ansTime + " " + ansHeight);
    }
}
/*  350 40

2 2 35
20 10
190 40

* */
