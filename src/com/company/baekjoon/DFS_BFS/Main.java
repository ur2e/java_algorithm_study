package com.company.baekjoon.DFS_BFS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int tmp = n;
        int cnt = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;


        while(tmp > 0) {
            if(tmp % 5 == 0)    {
                answer = Math.min(tmp / 5 + cnt, answer);
                if(cnt != 0) break;
                cnt = 0;
            }
            else if(tmp % 3 == 0)    {
                answer = Math.min(tmp / 3 + cnt, answer);
            }
            tmp -=3;
            cnt++;
        }

        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }
}
