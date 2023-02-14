package com.company.java_algorithm_study.Section1_String.문자열압축;

import java.util.*;

class Main {
    private String mySolution(String str) {
        String answer = "";

        char prev = str.charAt(0);
        int num = 0;
        for (char c: str.toCharArray()) {
            if(c == prev) {
                num++;
            } else {
                if(num == 1)    answer = answer + prev;
                else            answer = answer + prev + num;
                prev = c;
                num = 1;
            }
        }
        if(num != 1)   answer = answer + str.charAt(str.length()-1) + num;

        return answer;
    }

    private String solution(String s) {
        /*
         * 문자열의 i번째 문자와와 i+1번째 문자를 비교하기
         * 이때, 문자열의 맨 마지막 문자의 경우 i+1 인덱스가 존재하지 않아 에러가 발생한다.
         * 이를 방지하기위해 **문자열 뒤에 빈 문자를 하나 추가**해준다.
         *
         * */
        String answer = "";
        s = s + ""; // why? 문자열의 i번째 인덱스와 i+1 인덱스를 비교할 때 맨 마지막 문자의 index 범위 초과를 막기 위함.
        int cnt = 1;
        for(int i = 0; i < s.length() -1; i++){
            if(s.charAt(i) == s.charAt(i+1))    cnt++;
            else {
                answer += s.charAt(i);
                if(cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.mySolution(str));
    }
}
