package com.company.이코테.CH8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q34_병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] power = new int[n];
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(d, 1);
        for(int i = 0; i < n; i++){
            power[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(power[i] < power[j]){
                    d[i] = Math.max(d[j]+1, d[i]);
                }
            }
            max = Math.max(max, d[i]);
        }

        int answer = n - (max);
        System.out.println(answer);
    }




//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int[] power = new int[n+1];
//        int[] d = new int[n+1];
//
//        for (int i = 1; i <= n; i++) {
//            power[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int max = 0;
//        for (int i = 1; i <= n; i++) {
//            for(int j = i-1; j >= 0; j--){
//                if (power[i] < power[j]){
//                    d[i] = Math.max(d[i], d[j]+1);
//                }
//            }
//            //System.out.println(power[i] + " " + d[i]);
//            max = Math.max(max, d[i]);
//        }
//
//        int answer = n - (max + 1);
//        System.out.println(answer);
//
//    }
}
/*
7
10 9 20 8 30 7 50
 */