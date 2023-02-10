package com.company.java_algorithm_study.Section1_String.문장및단어뒤집기;

import java.util.ArrayList;
import java.util.Scanner;

public class 직접뒤집기 {
    public ArrayList<String> Solution(String[] str) {
        ArrayList<String> answer= new ArrayList<>();
        for(String x : str) {
            char[] s = x.toCharArray(); // 문자배열로 변경 // 문자 하나 하나에 접근하기위해 문자 배열로 바꿔준다.
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
        직접뒤집기 T = new 직접뒤집기();
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
