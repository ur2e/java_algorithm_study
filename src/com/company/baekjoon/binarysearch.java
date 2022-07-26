package com.company.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarysearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());


        long[] tree = new long[(int) n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

        }

        long l = 0;
        long r = Arrays.stream(tree).max().getAsLong();
        long sum;
        long answer = -1;
        long spare = Long.MIN_VALUE;


        while(l <= r){
            long mid = (l+r) / 2;

            sum = 0;
            for(int i = 0; i < n; i++){
                if(tree[i] < mid)   continue;
                else sum += tree[i] - mid;
            }
            if(sum > m) {
                l = mid + 1;
                spare = Math.max(spare, mid);
            }
            else if(sum < m) r = mid - 1;
            else {
                answer = mid;
                break;
            }
        }

        if(answer == -1) System.out.println(spare);
        else    System.out.println(answer);
    }
}