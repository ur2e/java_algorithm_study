package com.company.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어의개수1152 {
    public char alphaCount(char[] charArr){
        char answer = ' ';
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;

        for(char c : charArr){
            int idx = c-'A';
            count[idx] += 1;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A');
            }
            else if(count[i] == max) answer = '?';
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        단어의개수1152 T = new 단어의개수1152();
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        char[] charArr = br.readLine().toUpperCase().toCharArray();
        System.out.println(T.alphaCount(charArr));

    }
}