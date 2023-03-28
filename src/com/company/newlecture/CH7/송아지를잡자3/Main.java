package com.company.newlecture.CH7.송아지를잡자3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    final static int MAX = 200000;
    int[][] ch = new int[2][MAX+1];

    int solution(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int L = 0;
        while(!q.isEmpty()){
            int n = q.size();

            e += L;
            if(e > 200000)  break;
            for (int i = 0; i < n; i++) {
                int c = q.poll();

                if(c == e)    return L;

                if(c + 1 <= MAX && ch[L%2][c+1] == 0) {
                    ch[L%2][c+1] = 1;
                    q.offer(c+1);
                }

                if(c - 1 >= 0 && ch[L%2][c-1] == 0) {
                    ch[L%2][c-1] = 1;
                    q.offer(c-1);
                }

                if(c * 2 <= MAX && ch[L%2][c*2] == 0) {
                    ch[L%2][c*2] = 1;
                    q.offer(c*2);
                }
            }
            if(ch[L%2][e] == 1) return L+1;
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(T.solution(s, e));
    }
}
