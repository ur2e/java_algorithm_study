package com.company.newlecture.CH5;

import java.util.Arrays;

public class Q4_꽃이피는최단시간 {
    public int solution(int[] plantTime, int[] growTime){
        int n = plantTime.length;

        /*
        * flower 객체를 만들지 않고
        * 이차원 배열 time에 plantTime, grwoTime 관리
        * */
        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            time[i][0] = plantTime[i];
            time[i][1] = growTime[i];
        }

        // growTime 기준으로 내림차순 정렬
        Arrays.sort(time, (a, b) -> b[1] - a[1]);

        int start = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int end = start + time[i][0] + time[i][1];
            max = Math.max(end, max);
            start += time[i][0];
        }

        return max;
    }

    public static void main(String[] args){
        Q4_꽃이피는최단시간 T = new Q4_꽃이피는최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }

}
