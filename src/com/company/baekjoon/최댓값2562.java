package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        int num = 0, maxIdx = 1;

        for (int i = 1; i < 9; i++) {
            if ((num = Integer.parseInt(br.readLine())) > max) {
                max = num;
                maxIdx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx);
    }
}
