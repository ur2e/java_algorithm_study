package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 직사각형의경계선1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numArr = br.readLine().split(" ");

        int x = Integer.parseInt(numArr[0]);
        int y = Integer.parseInt(numArr[1]);
        int w = Integer.parseInt(numArr[2]);
        int h = Integer.parseInt(numArr[3]);

        System.out.println(Math.min(Math.min(x, y), Math.min(w-x, h-y)));
    }
}
