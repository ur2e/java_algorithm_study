package com.company.newlecture.CH5;

import java.util.Arrays;

public class Q1_침몰하는타이타닉 {
    // nums의 길이가 20만개 -> 20만개면 완전탐색 안돼.
    // point -> 2명이하 !
    // 2명 이하, 물건이 한 번에 이동할 때 2개 이하이다.
    // 중요 중요, 해결법이 따로 있다.
    // 양 쪽을 같이 조정하려고 하지말고
    // 1) 만약 무게 넘으면, 무거운 사람 태워보내(rt--, answer++);
    // 2) 무게 안 넘으면, 태워보낼 수 있으니까(lt++, rt--, answer++);
    // 3) lt == rt 에서는 70+70 이 논리적으로는 구린데
            // 답을 구하는데는 상관없다... lt가 rt 넘어서 끝나든, rt가 lt 넘어서 끝나든 끝나든..

    // 이분탐색 left, right
    // 제일 최적의 상황은 무거운 애랑 가벼운 애

    // 만약 제일 가벼운 사람과 제일 무거운 사람의 합이 m을 넘으면
    // 두번 째로 가벼운 사람을 선택? or 두번째로무거운 사람을 선택? 고민했음
    // 두번 째로 무거운 사람을 선택해라

    // 정리
    // 1) 오름차순 정렬
    // 2) 투 포인터 lt, rt
    // 3) 최적의 상황: 가장 무거운 사람 + 가장 가벼운 사람의 조합
    // +) 두 사람의 합을 구했는데 무게를 넘으면 과감히
    //    보트 한 개를 추가할 수 있는 강심장이 필요하다.

    // 왜? 바꿔서 해봐야지..
    public int solution(int[] nums, int m){
        int answer = 0;

        // 왜 정렬 안하는데~~
        Arrays.sort(nums);

        int lt = 0, rt = nums.length-1;

        while(lt <= rt){
            if(nums[lt] + nums[rt] > m) {
                rt--;
                answer++;
            } else {
                answer++;
                rt--;
                lt++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q1_침몰하는타이타닉 T = new Q1_침몰하는타이타닉();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
