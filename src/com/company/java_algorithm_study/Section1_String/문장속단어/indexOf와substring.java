package com.company.java_algorithm_study.Section1_String.문장속단어;

import java.util.Scanner;

public class indexOf와substring {
    public String Solution(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE, pos;

        while((pos = str.indexOf(" ")) != -1) {
            System.out.println(str);
            String tmp = str.substring(0, pos);// pos 전까지
            System.out.println(tmp);
            int len = tmp.length();
            if (len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }

        // 마지막 단어 고려해줘야함
        if(str.length() > max) answer = str;

        return answer;
    }
    public static void main(String[] args) {
        indexOf와substring T = new indexOf와substring();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}
