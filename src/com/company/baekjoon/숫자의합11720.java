package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split("");
        int sum = 0;

        for(String n : nums)
        sum += Integer.parseInt(n);

        System.out.println(sum);
    }
}
