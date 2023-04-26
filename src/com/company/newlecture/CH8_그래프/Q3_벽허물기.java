package com.company.newlecture.CH8_그래프;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3_벽허물기 {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m]; // 부셔야하는 최소 벽의 갯수
        int[][] ch = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0, 0, 0});
        //ch[0][0] = 1;
        cost[0][0] = 0;

        int L = 0;
        while(!pq.isEmpty()){

            int[] temp = pq.poll();

            for(int i = 0; i < 4 ;i++){
                //ch[temp[0]][temp[1]] = 1;
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx >=0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0){
                    if(cost[nx][ny] > cost[temp[0]][temp[1]] + board[nx][ny]) {
                        cost[nx][ny] = cost[temp[0]][temp[1]] + board[nx][ny];
                        pq.offer(new int[]{nx, ny, board[nx][ny]});
                    }
                }

            }
        }

        answer = cost[n-1][m-1];
        return answer;
    }

    public static void main(String[] args){
        Q3_벽허물기 T = new Q3_벽허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
