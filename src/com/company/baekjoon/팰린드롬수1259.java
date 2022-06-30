package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수1259 {

    public StringBuilder Solution() throws IOException {
        StringBuilder answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str, ans; // flag로 만들든... ans로 두든 ... ~
        int lt, rt;
        while ( !(str = br.readLine()).equals("0") ) {
            lt = 0; rt = str.length() - 1;
            char[] arr = str.toCharArray();
            ans = "yes";
            while(lt < rt) {
                if(arr[lt] != arr[rt]) {
                    ans = "no";
                    break;
                }
                lt++; rt--;
            }
            answer.append(ans).append("\n");
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        팰린드롬수1259 T = new 팰린드롬수1259();
        System.out.println(T.Solution());
    }
}
