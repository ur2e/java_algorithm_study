package com.company.이코테.CH8_DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Q8_효율적인화폐구성 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coin = new int[n];

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001); // fill 함수 기억하자

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        d[0] = 0;
        for (int i = 0; i < n; i++) { // 동전들을 기준으로 ! why? 딱 정해진게 아니니까 Fn=Fn-1+Fn-2 이 방법보다
                                        // 동전을 기준으로 값을 게속 최소화 시키는게 좋다.
            for (int j = coin[i]; j <= m; j++) {
                // (i - k)원을 만드는 방법이 존재하는 경우
                if (d[j - coin[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - coin[i]] + 1);
                }
            }
        }

        // 계산된 결과 출력
        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
    }
}
