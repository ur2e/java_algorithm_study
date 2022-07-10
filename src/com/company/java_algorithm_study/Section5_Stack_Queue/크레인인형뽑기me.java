package com.company.java_algorithm_study.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기me {
    static Stack<Integer> stack = new Stack<>();
    static int[][] board;
    static int n;

    public int search(int y){
        int number = -1;
        for(int i = 1; i <= n; i++){
            if(board[i][y] != 0) {
                number = board[i][y];
                board[i][y] = 0;
                break;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        크레인인형뽑기me T = new 크레인인형뽑기me();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int answer = 0;
        board = new int[n+1][n+1];
        // 배열 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int move = sc.nextInt();

            // 맨 위의 값 찾기
            int num = T.search(move);
            if(num == -1) continue;
            else {
                if(!stack.isEmpty() && stack.peek() == num){
                    answer += + 2;
                    stack.pop();
                }
                else stack.push(num);
            }
        }

        System.out.println(answer);
    }
}
