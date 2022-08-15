package com.company.java_algorithm_study.Section3_Twopointers.두배열합치기;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // 코테에서 진짜 이 문제를 정렬하면 곤란하다.
    // two pointer 알고리즘 알고 있는지 물어보는 거임

    // a 배열 탐색하는 p1
    // b 배열 탐색하는 p2
    // p1, p2 둘 중에 하나가 탐색을 완료하면,
    // 남은 쪽을 모두 배열에 넣어주면 끝 !
    ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while(p1 < n && p2 < m){
            if(a[p1] < b[p2])   answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1 < n) answer.add(a[p1++]);
        while(p2 < m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for(int x: T.solution(n, m , a, b))
            System.out.print(x + " ");
    }
}
