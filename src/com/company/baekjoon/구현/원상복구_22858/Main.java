package com.company.baekjoon.구현.원상복구_22858;

import java.io.*;
import java.util.*;

public class Main {
    private StringBuilder solution(int n, int k, int[] result, int[] rule){
        StringBuilder sb = new StringBuilder();

        // result[i]를 rule[i]의 인덱스로 옮긴다.
        int mixCnt = 0;
        int[] tmp = result.clone();
        while(mixCnt < k){
            mixCnt++;
            for (int i = 0; i < n; i++) {
                tmp[rule[i]-1] = result[i];
            }
            result = tmp.clone();
        }

        for(int x: tmp){
            sb.append(x).append(" ");
        }

        return sb.deleteCharAt(sb.lastIndexOf(" "));
    }

    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 카드의 개수
        int k = Integer.parseInt(st.nextToken()); // 카드 섞은 횟수

        int[] result = new int[n];
        int[] rule = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rule[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, k, result, rule));
    }
}
