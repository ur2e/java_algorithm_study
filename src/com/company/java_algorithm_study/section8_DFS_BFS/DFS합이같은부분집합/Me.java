package com.company.java_algorithm_study.section8_DFS_BFS.DFS합이같은부분집합;


import java.util.Scanner;

public class Me {
    static int sum, num, tmpSum = 0;
    static int[] ch, arr;
    static String answer;

    static void DFS(int v) {
        if(v == num+1) {
            for(int i = 1; i <= num; i++) {
                if(ch[i] == 1) {
                    tmpSum += arr[i];
                }
            }
            if(tmpSum == sum-tmpSum) {
                answer = "YES";
            }
            tmpSum = 0;
        }
        else {
            ch[v] = 1;
            DFS(v+1);

            ch[v] = 0;
            DFS(v+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num + 1];

        sum = 0;
        ch = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        answer = "NO";
        DFS(1);
        System.out.println(answer);
    }
}


