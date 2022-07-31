package com.company.java_algorithm_study.Section1_String.문자열압축;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();

        String[] str = sc.nextLine().split("");
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length; i++) {
            if (!str[i].equals(str[i - 1])) {
                if (count > 1) sb.append(str[i - 1]).append(count);
                else sb.append(str[i - 1]);
                count = 1;
            } else {
                count++;
                if (i == str.length - 1) {
                    if (count > 1) sb.append(str[i - 1]).append(count);
                    else sb.append(str[i - 1]);
                }
            }
        }
        System.out.println(sb);
    }
}
