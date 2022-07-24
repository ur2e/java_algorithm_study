package com.company.baekjoon.구현.빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    int isBingo(boolean[][] board, int x, int y){
        // 세로 줄, 가로 줄 , 왼쪽 대각선, 오른쪽 대각선
        // 3,0 이면     0,0 1,0 2,0 3,0 4,0    세로줄
        // 3.0 이면       3.0 3,1 3,2, 3.3 3.4 해야대  가로줄
        // 0.0 1.1 2.2 3.3 4.4 왼쪽 대각선
        // 0.4 1.3 2.2 3.1 4.0 오른쪽 대각선

        // 가로줄
        int bingo = 12;
        for(int ny = 0; ny < 5; ny++){
            for (int nx = 0; nx < 5; nx++) {
                if (!board[nx][ny]) {
                    bingo--;
                    break;
                }
            }
        }

        // 세로줄
        for (int nx = 0; nx < 5; nx++) {
            for(int ny = 0; ny < 5; ny++){
                if (!board[nx][ny]) {
                    bingo--;
                    break;
                }
            }
        }
        // 대각선
        for (int n = 0; n < 5; n++) {
            if (!board[n][n]) {
                bingo--;
                break;
            }
        }

        for (int n = 0; n < 5; n++) {
            if (!board[n][4-n]){
                bingo--;
                break;
            }
        }

        return bingo;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Node> map = new HashMap<>();
        boolean[][] board = new boolean[5][5];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new Node(i, j));
            }
        }

        int bingo = 0;
        int answer = 0;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                answer++;
                Node callNum = map.get(num);

                board[callNum.x][callNum.y] = true;

                bingo = T.isBingo(board, callNum.x, callNum.y);

                if(bingo >= 3) break;

            }
            if(bingo >= 3) break;
        }

        System.out.println(answer);
    }
}
