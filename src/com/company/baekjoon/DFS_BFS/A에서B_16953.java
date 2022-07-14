package com.company.baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A에서B_16953 {
    static long a, b;
    static int answer = -1;
    static void dfs(long n, int count){
        if(answer != -1) return;
        if(n == b) {
            answer = count;
            return;
        }
        else if(n > b)   return;
        else{
            //System.out.println(count + " " + n);
            dfs(n*2, count+1);
            long tmp = (n*10) + 1;
            dfs(tmp, count+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(a, 1);

        System.out.println(answer);
    }
}
