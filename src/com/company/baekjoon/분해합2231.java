package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int answer = 0;
        int num = 1;
        int numArrSum = 0;
        while(num < input ) {
            num++;
           // int tmpNum = num;
            String tmpNum = String.valueOf(num);

            for(String i : tmpNum.split("")) {
                numArrSum += Integer.parseInt(i);
            }

//            while(tmpNum != 0) {
//                numArrSum += tmpNum % 10;
//                tmpNum /= 10;
//            }

            if (input == num + numArrSum) {
                answer = num;
                break;
            }
            numArrSum = 0;
        }
        System.out.println(answer);
    }
}
