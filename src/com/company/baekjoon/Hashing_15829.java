package com.company.baekjoon;


import java.io.*;

public class Hashing_15829 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long answer = 0;
        long pow = 1;
        int m =  1234567891;
        for(int i = 0; i < l; i++) {
            long num = (long) str[i] - 96;
            //sum += ((s.charAt(i)-'a'+1)*r)%prime;
            answer += num * pow;
            pow *= 31;
            pow %= m;
        }

        System.out.println(answer % m);
    }
}
