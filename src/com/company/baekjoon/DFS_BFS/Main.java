package com.company.baekjoon.DFS_BFS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String str;
        Scanner sc = new Scanner(System.in);
        while (!(str = sc.nextLine()).equals("END")) {
            StringBuilder sb = new StringBuilder(str).reverse();
            System.out.println(sb);
        }
    }
}
