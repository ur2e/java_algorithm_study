package com.company.java_algorithm_study.section8_DFS_BFS.동전교환;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Me {
    static int n, money, answer = Integer.MAX_VALUE;

    // 배열 내림차순하기 위해서 Integer[] 을 사용한다 !
    static Integer[] coin;

    public void dfs(int sum, int count){
        // 동전 더한 값이 거스름보다 크면 종료
        if(sum > money) return ;

        // 동전 갯수가 최소 동전 갯수보다 많으면 종료
        if(count >= answer) return;

        // 거스름돈 가격이 맞춰졌어면 최소 동전 갯수 계산
        if(sum == money)    {
            if(count < answer) answer = count;
            return;
        }
        else {
            for(int i = 0 ; i < coin.length; i++){
                dfs(sum + coin[i], count+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Me T = new Me();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        coin = new Integer[n];
        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        money = Integer.parseInt(br.readLine());
        Arrays.sort(coin, Collections.reverseOrder());
        T.dfs(0, 0);
        bw.write(answer+"\n");
        bw.flush();
    }
}
