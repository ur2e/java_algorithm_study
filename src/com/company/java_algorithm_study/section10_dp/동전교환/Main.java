package com.company.java_algorithm_study.section10_dp.동전교환;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n , m;
    static int[] dy;
    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE); // dy에는 최소 동전 개수를 계속 업데이트해줘야 해서 가장 큰 값으로 초기화한다.
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m ; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] coin = new int[n];
        for(int i = 0; i < n; i++){
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1]; // 거스름 돈 m의 인덱스 값도 계산해야하기 때문에 m+1로 초기화한다.
        System.out.println(T.solution(coin));
    }
}
