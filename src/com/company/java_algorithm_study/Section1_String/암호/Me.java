package com.company.java_algorithm_study.Section1_String.암호;
import java.util.Scanner;

public class Me {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String tmp = sc.nextLine();
        String str = sc.nextLine();

        int size = 0; // 나는 size로 7개씩 잘랐는데.. substring을 쓰면 된다.
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(char x : str.toCharArray()){
            size++;
            if(x == '#')    sb.append(1);
            else sb.append(0);
            if(size == 7)   {
                answer.append((char) Integer.parseInt(String.valueOf(sb), 2));
                size = 0;
                for(int i = 0; i < 7; i++){
                    sb.delete(0, 7);
                }
            }
        }
        System.out.println(answer);
    }
}