package com.company.baekjoon.Greedy;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 동전의 개수가 최소가 되야하니 5원짜리가 최대한 많아야한다.
        // 거스름 돈이 5의 배수가 될 때 까지 2원을 빼주면서
        // 5의 배수가 되면 거스름돈을 5원으로 준다.

        int cnt = 0;
        while(n > 0){
            if(n % 5 == 0){
                cnt += n / 5;
                break;
            }
            n -= 2;
            cnt++;
        }
        if(n < 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
