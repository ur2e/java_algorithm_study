package com.company.baekjoon.sprout;

import java.io.*;

public class 기찍N2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());

        while(n>0) {
            bw.write(n+"\n");
            n--;
        }
        bw.flush();
    }
}