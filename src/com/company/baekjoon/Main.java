package com.company.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int start = 1;
        int day, night, answer=1;
        int nextDay = a-b;
        while(start < v) {
            start += a;
            answer++;
            if(start >= v) break;
            start -= b;

        }
        System.out.println(answer);
    }
}
