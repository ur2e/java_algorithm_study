package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACM호텔10250 {
    public String assign(int H, int W, int N){
        StringBuilder answer = new StringBuilder();
        if ( N % H == 0) {
            answer.append(H);
            if( N / H < 10) answer.append("0").append(N / H);
            else  answer.append(N / H);
        }
        else {
            answer.append(N % H);
            if( N / H < 9) answer.append("0").append(N / H + 1);
            else  answer.append(N / H + 1);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        ACM호텔10250 M = new ACM호텔10250();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
           String[] strArr = br.readLine().split(" ");
           System.out.println(M.assign(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }
    }
}
