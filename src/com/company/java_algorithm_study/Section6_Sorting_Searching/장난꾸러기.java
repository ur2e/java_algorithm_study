package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] stu = new int[num];
        int[] sortedStu;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++) {
            int height = sc.nextInt();
            stu[i] = height;
        }
        // 깊은 복사 방법 1) Arrays.copyOf(복사할 배열명, 복사할 배열의 길이)
        sortedStu = Arrays.copyOf(stu, stu.length);

        // 깊은 복사 방법 2) Object.clone();
        // sortedStu = stu.clone();
        Arrays.sort(sortedStu);

        for(int i = 0; i < num; i++) {
            if(stu[i] != sortedStu[i]) sb.append(i+1).append(" ");
        }

        System.out.println(sb);
    }
}
