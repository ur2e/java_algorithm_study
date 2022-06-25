package com.company.java_algorithm_study.String;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기직접 {
    public ArrayList<String> Solution(String[] str) {
        ArrayList<String> answer= new ArrayList<>();
        for(String x : str) {
            char[] s = x.toCharArray(); // 문자배열 생성
            int lt=0, rt=x.length()-1;
            while(lt < rt) {
                char tmp = s[lt];
                s[lt++] = s[rt];
                s[rt--] = tmp;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        단어뒤집기직접 T = new 단어뒤집기직접();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strArr = new String[num];
        for(int i = 0 ; i < num; i++) {
            strArr[i] = sc.next();
        }
        for(String s: T.Solution(strArr)) {
            System.out.println(s);
        }
    }
}
