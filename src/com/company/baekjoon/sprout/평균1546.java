package com.company.baekjoon.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 평균1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        double max = Integer.MIN_VALUE;
        double sum = 0;
        double avg = 0;
        String[] temp = br.readLine().split(" ");
        int[] scores = new int[num];

        for(int i = 0; i < num; i++){
            scores[i] = Integer.parseInt(temp[i]);
            if( scores[i] > max) max = scores[i];
        }

        for(int s : scores) {
            sum += (s/max) * 100;
        }

        avg = sum / num;
        System.out.println(avg);
    }
}
