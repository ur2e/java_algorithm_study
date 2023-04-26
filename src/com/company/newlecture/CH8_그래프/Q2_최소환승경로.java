package com.company.newlecture.CH8_그래프;

import java.util.*;

public class Q2_최소환승경로 {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;

        for (int i = 0; i < n; i++) {
            // 0 호선 역들
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<>());
                graph.get(x).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ch = new int[n]; // 호선 체크
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int curr = q.poll();

                // 1번 역의 호선 정보
                for(int line: graph.get(curr)) {
                    if(ch[line] == 1)   continue;

                    // 호선 체크하기
                    ch[line] = 1;
                    for(int stop: routes[line]){
                        if(stop == e)   return L;
                        q.offer(stop);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Q2_최소환승경로 T = new Q2_최소환승경로();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
