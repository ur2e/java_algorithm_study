package com.company.baekjoon.투포인터.q21921_블로그;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // x일동안 가장 많이 접속한..
        // x만큼 sum을 만들어놓고.
        // max = sum, 그 이후는 Math.max(max, sum), answer = 1
        // if max == sum , answer++;
        int sum = 0, max = 0, answer = 1;
        for(int i = 0; i < x; i++)  sum += arr[i];
        max = sum;

        for(int i = x; i < n; i++){
            sum += arr[i] - arr[i-x];
            if(sum > max){
                max = sum;
                answer = 1;
            } else if(sum == max)  answer++;
        }
        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(answer);
        }
    }
}
