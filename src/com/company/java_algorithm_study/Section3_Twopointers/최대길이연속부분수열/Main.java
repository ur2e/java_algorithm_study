package com.company.java_algorithm_study.Section3_Twopointers.최대길이연속부분수열;

import java.util.Scanner;

public class Main {
    private int solution(int l, int n, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;
        for (int rt = 0; rt < l; rt++) {
            if (arr[rt] == 0) cnt++;
            // 0 -> 1의 개수가 n개로 맞추기 위한 while문
            while (cnt > n) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(len, n, arr));

        // rt는 0을 만나면 무조건 1로 바꾼다 -> 바꾸고 cnt++
        // cnt < k 라면 answer 값 갱신
    }
}
