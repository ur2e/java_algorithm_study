package com.company.baekjoon.구현;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 소가길을걸어간이유14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0 ;
        Map<Integer, Integer> cow = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int loc = sc.nextInt();

            if(cow.get(c) == null) cow.put(c, loc);
            else {
                if ( cow.get(c) != loc ) {
                    answer++;
                    cow.put(c, loc);
                }
            }
        }

        System.out.println(answer);
    }
}
