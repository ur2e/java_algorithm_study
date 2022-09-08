package com.company.java_algorithm_study.section8_DFS_BFS.피자배달거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    // 행 : x, 열 : y
    public int x;
    public int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    private static int n, m, len, answer = Integer.MAX_VALUE;
    private static int[] combi;
    private static ArrayList<Point> pz, hs;
    public void DFS(int L, int s){
        // 조합이 완성되었다면
        if(L == m) {
            int sum = 0;
            // 집과 조합으로 선택된 피자집 사이의 거리를 모두 계산한다.
            for(Point h: hs){
                int dis = Integer.MAX_VALUE;
                // 집 하나랑 피자 집들의 조합이랑 하나 하나 다 계산한다.
                for(int i : combi){
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y-pz.get(i).y));
                }
                sum += dis; // 도시의 피자배달거리
            }
            answer = Math.min(answer, sum);
        }
        else {
            for(int i = s; i < len; i++){
                combi[L] = i; // 0~ 5 사이에서 m 개를 뽑아내자.
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        조합이 하나 완성될 때마다 하나하나 계산해주어야한다.
         */
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pz = new ArrayList<>();
        hs = new ArrayList<>();

       // int[][] board = new int[n][n]; 이거 필요없다 !
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1)   hs.add(new Point(i, j));
                else if(tmp == 2)   pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];

        // 경우의 수(조합)을 계산
        // 조합 구하는 것은 그냥 외우자
        T.DFS(0, 0);
        System.out.println(answer);

    }
}
