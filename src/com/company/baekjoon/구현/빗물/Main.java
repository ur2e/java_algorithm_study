package com.company.baekjoon.구현.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] board = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }

        int l = -1; int lIdx = -1;
        int groundMin = Integer.MAX_VALUE;
        int answer = 0;
        int ground = 0;
        int r = -1;
        for(int i = 0; i < w; i++){

        }

        System.out.println(answer);

    }
}
