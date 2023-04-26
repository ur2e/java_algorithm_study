package com.company.newlecture.CH5;

import java.util.Arrays;

class Range{
    int start, end;
    Range(int start, int end){
        this.start = start;
        this.end = end;
    }

//    @Override
//    public int compareTo(Object o) {
//        if(this.start == ((Range)o).start) {
//            return this.end - ((Range)o).end;
//        }
//        return this.start - ((Range)o).start;
//    }
}
public class Q3_스프링쿨러 {
    public int solution(int n, int[] nums){
        int answer = 0;
        Range[] range = new Range[n];

        // 범위 배열 생성
        for(int i = 0; i < n; i++){
            range[i] = new Range(Math.max(i - nums[i], 0), Math.min(i + nums[i], n-1));
            //  i - nums[i] < 0 ? 0 : i - nums[i]; 대신 max 사용 오..
        }

        // 시작 시점을 기준으로 오름차순 정렬
        Arrays.sort(range, (a,b) -> a.start  - b.start);
        /* Comparable 구현하지 않고 이렇게 써도 된다.*/

//        for (Range r : range) {
//            System.out.println(r.start  + " " + r.end);
//        }

        int s = 0;
        int e = 0;
        int idx = 0;

        for(int i = 0; i < n; i++){
            s = e;
            while(range[i].start <= s){
                e = Math.max(range[i].end, e);
                i++;
                if(i >= n) break;
            }
            answer++;
        }

        if(s == e)  answer = -1;

        return answer;
    }

    public static void main(String[] args){
        Q3_스프링쿨러 T = new Q3_스프링쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
