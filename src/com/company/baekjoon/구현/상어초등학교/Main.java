package com.company.baekjoon.구현.상어초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
    static int[] dx = {-1, 0, 0, 1}; // 상 좌 우 하
    static int[] dy = {0, -1, 1, 0};
    static int[][] arr, room;
    static int studentCnt, n;
    static Map<Integer, Node> seat = new HashMap<>();
    static int cal(int[] stu, Node loc){
        int answer = 0;
        int like = 0;
        for (int k = 0; k < 4; k++) {
            int nx = loc.x + dx[k];
            int ny = loc.y + dy[k];
            if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                for (int x = 1; x < 5; x++) {
                    if (stu[x]== room[nx][ny]) {
                        like++;
                    }
                }
            }
        }
        if(like == 1 ) answer = 1;
        else if( like == 2 ) answer = 10;
        else if( like == 3 ) answer = 100;
        else if( like == 4) answer = 1000;
        return answer;
    }

    static void solution(int[] stu) {
        int like = 0, blank = 0, maxLike = -1, maxBlank = -1;

        Node likeSeat = new Node(0, 0);
        Node blankSeat = new Node(0, 0);
        int likeSeatBlank = -1;
        boolean overlapFlag = false;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(room[i][j] != 0) continue;
                like = 0; blank = 0;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx > 0 && nx <= n && ny > 0 && ny <= n) {
                        if(room[nx][ny] == 0) blank++;
                        // 빈자리 아니야. 그러면 짝꿍이야 ?
                        else {
                            for(int x = 1; x < 5; x++){
                                if(stu[x] == room[nx][ny]) like++;
                            }
                        }
                    }
                }

                if(blank > maxBlank) {
                    maxBlank = blank;
                    blankSeat = new Node(i, j);
                }

                if(like > maxLike) {
                    maxLike = like;
                    likeSeat = new Node(i, j);
                    likeSeatBlank = blank;

                } else if(like == maxLike) {
                    overlapFlag = true;
                }

                if(overlapFlag) {
                    if(likeSeatBlank < blank) {
                        likeSeat = new Node(i, j);
                        likeSeatBlank = blank;
                    }
                    overlapFlag = false;
                }
            }
        }
        if(maxLike != -1){
            // 중복된 like 값이 있다면
            room[likeSeat.x][likeSeat.y] = stu[0];
            seat.put(stu[0], new Node(likeSeat.x, likeSeat.y));
        }
        else {
            room[blankSeat.x][blankSeat.y] = stu[0];
            seat.put(stu[0], new Node(blankSeat.x, blankSeat.y));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        studentCnt = n * n;
        arr = new int[studentCnt+1][5];
        room = new int[n+1][n+1];
        for (int i = 1; i <= studentCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= studentCnt; i++) {
            solution(arr[i]);
        }
        int answer = 0;
        for (int i = 1; i <= studentCnt; i++) {
            answer += cal(arr[i], seat.get(arr[i][0]));
        }
        System.out.println(answer);
    }
}
