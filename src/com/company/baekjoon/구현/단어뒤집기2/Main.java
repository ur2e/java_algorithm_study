package com.company.baekjoon.구현.단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        ArrayList<StringBuilder> arr = new ArrayList<StringBuilder>();
        arr.add(new StringBuilder());
        int idx = 0;

        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            // 괄호 안에 있는 문자
            if (flag) {
                sb.append(c[i]);
                if (c[i] == '>') flag = false;
            }
            // 괄호 밖에 있는 문자
            else {
                if (c[i] == ' ') {
                    sb.append(arr.get(idx).reverse()).append(" ");
                    arr.add(new StringBuilder());
                    idx++;
                } else if (c[i] == '<') {
                    sb.append(arr.get(idx).reverse()).append("<");
                    arr.add(new StringBuilder());
                    idx++;
                    flag = true;
                } else {
                    if (c[i] == ' ') {
                        sb.append(arr.get(idx).reverse()).append(" ");
                        arr.add(new StringBuilder());
                        idx++;
                    } else if(i == c.length - 1){
                        arr.get(idx).append(c[i]);
                        sb.append(arr.get(idx).reverse());
                    }
                    else {
                        arr.get(idx).append(c[i]);
                    }

                }


            }

        }
        System.out.println(sb);

    }
}
