package com.company.baekjoon.투포인터.q11728_배열합치기;

import com.company.java_algorithm_study.Section3_Twopointers.최대매출.Me;

import java.io.*;
import java.util.*;

public class Main {
    /**
     *  시간초과떄문에 solution 함수로 따로 안 쓰고, ArrayList 대신 StringBuilder 이용함
     */
    public static void main(String[] args) throws IOException{
        Me T = new Me();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m){
            if(a[p1] > b[p2])   sb.append(b[p2++]).append(" ");
            else sb.append(a[p1++]).append(" ");
        }
        while(p1 < n) sb.append(a[p1++]).append(" ");
        while(p2 < m) sb.append(b[p2++]).append(" ");

        System.out.println(sb.toString().trim());
    }
}
