package com.company.newlecture.CH5;

import java.util.Arrays;

public class Q2_이동횟수 {
    /*
    - 한 번에 5kg 이하, 여러 개를 옮길 수 있다.
    - -> 이거 타이타닉이랑 비슷하다 !
        - 타이타닉은 한 보트에 2명 이하, 140kg이하

    - 이 문제는 여러 개를 들 수 있다는데...
    - 너무 어렵다 ㅠㅠ 할게 아니라 제한 사항에 모든 무게의 2kg ~ 5kg
    - 그래서 제일 작은 무게는 2개를 3개만 들어도 초과한다.

    - 결국 !  모든 물건은 2개 밖에 못 드네~~

     */
    public int solution(int[] nums){
        int answer = 0;
        int lt = 0, rt = nums.length-1;

        Arrays.sort(nums);

        while(lt <= rt) {
            int sum = 0;
            if(nums[lt] + nums[rt] <= 5) {
                answer++;
                lt++; rt--;
            } else {
                answer++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q2_이동횟수 T = new Q2_이동횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}

