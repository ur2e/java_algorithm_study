package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String mul = Integer.toString(a*b*c);
        int[] nums = new int[10];

        for(char x : mul.toCharArray()){
            nums[Integer.parseInt(Character.toString(x))] += 1;
        }

        for(int x : nums){
            System.out.println(x);
        }
    }
}
