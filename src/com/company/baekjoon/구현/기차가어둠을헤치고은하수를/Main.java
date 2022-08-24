package com.company.baekjoon.구현.기차가어둠을헤치고은하수를;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 기차 수
        int m = Integer.parseInt(st.nextToken()); // 명령 수

        int[][] train = new int[n][21];
        int[] order= new int[m];
        int[] trainNum = new int[m];
        int[] seatNum = new int[m];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
            trainNum[i] = Integer.parseInt(st.nextToken());
            if(order[i] < 3) seatNum[i] = Integer.parseInt(st.nextToken());
        }

        Map<String, Integer> trainState = new HashMap<>();

        for(int i = 0; i < m; i++){

            System.out.println("================================================");
            // 승차
            if(order[i] == 1){
                // 0 -> 1, 1-> 1
                train[trainNum[i]-1][seatNum[i]-1] |= 1;
            }
            //하차
            else if(order[i] == 2){
                // 0 -> 0, 1 -> 0
                train[trainNum[i]-1][seatNum[i]-1] |= 0;
            }
            // 모두 뒤로
            else if(order[i] == 3){
                System.out.println("?");
                for(int j = 0; j < 20; j++) {
                    //t[j+1] = t[j];
                    // train[trainNum[i]-1] <<= 1;
                }
            train[trainNum[i]-1][0] = 0;
            }
            // 모두 앞으로
            else {
                for (int j = 19; j > 0; j--) {
                    //t[j-1] = t[j];
                    train[trainNum[i]-1][j] = train[trainNum[i]-1] [j] >> 1;
                }
                train[trainNum[i]-1][10] = 0;
            }
            for(int[] t : train){
                for(int x: t){
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }

        // 기차 상태 기록 & 비교
        for(int[] t: train){
            StringBuilder sb = new StringBuilder();
            sb.append(Arrays.toString(t));
            System.out.println("sb = " + sb);
            trainState.put(sb.toString(), trainState.getOrDefault(sb.toString(), 0) + 1);
        }
        for(String x: trainState.keySet()){
            System.out.println(x + " " + trainState.get(x));
        }
        System.out.println(trainState.size());
    }
}
