package com.company.이코테.CH7_이진탐색;

import java.util.Scanner;
import java.util.TreeMap;

public class Q2_부품찾기 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), 0);
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            if(map.get(sc.nextInt()) != null) sb.append(1 + " ");

            else    sb.append(0 + " ");
        }

        System.out.println(sb.toString().trim());
    }
}
