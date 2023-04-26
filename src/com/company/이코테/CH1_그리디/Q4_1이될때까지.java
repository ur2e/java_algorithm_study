package com.company.이코테.CH1_그리디;

import java.util.Scanner;

public class Q4_1이될때까지 {
    // 아이디어
    // 무조건 k로 나눠야 이득이다. => 최대한 많이 나누기
    // 나눌 수 있으면 나누고,
    // 나눌 수 없다면 나눌 수 있을 때까지 1을 뺀다.

    // 왜? 2 이상의 수로 나누는 것이 1을 빼는 것보다
    // 숫자를 훨씬 많이 줄일 수 있기 떄문이다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;
        while(n > 1) {
            if(n % k == 0) {
                n /= k;
            } else {
                n--;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
