package com.company.baekjoon.구현.봄버맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bomb {
    char bomb;
    int sec;
    Bomb(char bomb, int sec){
        this.bomb = bomb;
        this.sec = sec;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Bomb[][] board = new Bomb[r][c];

        // 폭탄 상태 입력받으면서 초기화
        for(int i = 0 ; i < r; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                board[i][j] = new Bomb(tmp[j], 0) ;
            }
        }

        int[] dx = {1, -1 ,0 ,0};
        int[] dy = {0, 0, 1, -1};

        if(n >= 2) {
            int time = 2;
            boolean step = true;
            while(time++ <= n){

                step = !step;
                // 폭탄 터짐
                if(step) {
                    for(int i = 0 ; i < r; i++){
                        for(int j = 0; j < c; j++){
                            // 폭탄이 터진다 !
                            if(board[i][j].bomb == 'O' && board[i][j].sec+3 == time) {
                                board[i][j].bomb = '.';
                                for(int k = 0; k < 4; k++){
                                    int nx = i + dx[k];
                                    int ny = j + dy[k];
                                    // 인접한 칸 파괴.
                                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                                        if(board[nx][ny].sec+3 != time)   board[nx][ny].bomb = '.';
                                    }
                                }
                            }
                        }
                    }
                }
                // 폭탄 설치
                else {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (board[i][j].bomb == '.') {
                                board[i][j].bomb = 'O';
                                board[i][j].sec = time;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(board[i][j].bomb);
            }
            System.out.println();
        }
    }
}
