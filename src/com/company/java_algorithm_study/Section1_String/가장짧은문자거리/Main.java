package com.company.java_algorithm_study.Section1_String.가장짧은문자거리;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = sc.next();
        int[] dist = new int[str.length()];

        char[] arr = str.toCharArray();

        int index = str.indexOf(c);
        for(int i = 0; i < str.length(); i++){
            dist[i] = Math.abs(index - i);
        }

        while(true){
            index = str.indexOf(c, index+1);
            if(index == -1) break;
            else {
                for(int i = 0; i < str.length(); i++){
                    if(dist[i] > Math.abs(i - index)){
                        dist[i] = Math.abs(i - index);
                    }
                }
            }
        }
        for(int x: dist){
            System.out.printf(x + " ");
        }
    }
}