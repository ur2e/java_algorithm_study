package com.company.java_algorithm_study.Section3_Twopointers.연속부분수열_다시보기;

import java.util.Scanner;

public class Me {
    private int solution(int n, int m, int[] arr){
        int answer = 0;

        for(int i = 0; i < n; i++){
            int p1 = i, p2 = p1+1;
            int sum = arr[i];
            while(p2 < n) {
                if(sum < m) sum += arr[p2++];
                else if (sum == m)  {
                    answer++;
                    break;
                }
                else break;
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Me T = new Me();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(T.solution(n ,m, arr));
    }
}
