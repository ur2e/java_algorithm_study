package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 직각삼각형4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answer = new ArrayList<>();
        int a, b, c;
        String str = "";
        String[] strArr = new String[3];
        int[] intArr = new int[3];

        while(!(str = br.readLine()).equals("0 0 0")) {
            strArr = str.split(" ");

            // 제일 큰 값을 C로 놓자
            for(int i = 0; i < 3; i++){
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            //Arrays.sort(intArr);

            a = intArr[0];
            b = intArr[1];
            c = intArr[2];


            if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)) answer.add("right");
            else answer.add("wrong");
        }

        for(String ans: answer) {
            System.out.println(ans);
        }
    }
}
