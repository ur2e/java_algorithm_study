package com.company.javaBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr, room;
    static int studentCnt, n;

    static void solution(int[] stu) {
        // room을 1,1 부터 돌면서 칸을 확인해.
        // 가장 빈 곳이 많은 room에 stuNum을 넣는다.
        int like = 0, blank = 0, maxLike = -1, maxBlank = -1;
        boolean likeFlag = false, blankFlag = false;

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                // room[i][j]는 후보 자리
                Node likeSeat = new Node(0, 0);
                Node blankSeat = new Node(0, 0);
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx > 0 && nx <= n && ny > 0 && ny <= n){
                        // 옆자리가 좋아하는 사람이 있으면
                        if (room[nx][ny] != 0) {
                            for(int x = 1; x <= 4; x++){
                                if(stu[x] == room[nx][ny]) {
                                    like++;
                                    if(maxLike < like) {
                                        maxLike = like;
                                        likeSeat.x = nx;
                                        likeSeat.y = ny;
                                    }
                                    else if(maxLike == like) likeFlag = true;
                                }
                            }
                        }
                        // 옆자리가 빈 자리면
                        else {
                            blank++;
                            if(maxBlank < blank) {
                                maxBlank = blank;
                                blankSeat.x = nx;
                                blankSeat.y = ny;
                            }
                            else if(maxBlank == blank) {
                                blankFlag = true;
                            }
                        }
                    }
                }
                // 한 자리에 대한 탐색이 끝났으면 조건 따져
                // 조건 1 좋아하는 사람 겹치는 곳 없음 -> 가장 많은 곳으로 이동
                if(!likeFlag)   {
                    room[likeSeat.x][likeSeat.y] = stu[0];
                }
                else if(likeFlag && !blankFlag) {
                    room[blankSeat.x][blankSeat.y] = stu[0];
                } else if(blankFlag) {

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        studentCnt = n * n;

        arr = new int[studentCnt+1][6];
        room = new int[n+1][n+1];
        for (int i = 1; i <= studentCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조건 1 : if(blank) 좋아하는 학생이면 like++
        // 상하좌우로 이동하면서.. 빈차리를 찾으면 -> blank++


        for (int i = 1; i <= studentCnt; i++) {
            solution(arr[i]);
        }


    }
}
