package com.company.baekjoon;

import java.sql.SQLOutput;
import java.util.Scanner;

public class 정수제곱근 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long l = 0;
        long r = Long.MAX_VALUE;
        long q = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (mid > (long) Math.sqrt(n)) {
                q = Math.min(q, mid);
                r = mid - 1;
            } else if (mid < (long) Math.sqrt(n)) {
                l = mid + 1;
            } else {
                q = mid;
                break;
            }
        }

        System.out.println(q);
        System.out.println(q >= (long) Math.sqrt(n));
        System.out.println(11060446 > (long) Math.sqrt(n));
    }
}
