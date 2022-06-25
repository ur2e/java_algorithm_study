package com.company.baekjoon.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int level = 0;
        int num = 1;
        int answer = 0;

        while (num < input){
            num = num + (6 * level); // 1
            level++;
        }

        answer = level;
        if (input == 1) answer = 1;
        System.out.println(answer);
    }
}
