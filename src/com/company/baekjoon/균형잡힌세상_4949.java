package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String ans;

        while(true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            char[] arr = str.toCharArray();
            for (char x : arr) {
                if (x == '[' || x == '(') {
                    stack.push(x);
                } else if (x == ']' || x == ')') {
                    if (stack.isEmpty()) {
                        break;
                    } else if (x == ']' && stack.peek() == '(') {
                        break;
                    } else if (x == ')' && stack.peek() == '[') {
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            // 여는 괄호가 더 많은 상황
            if (!stack.isEmpty()) {
                ans = "no";
                stack.clear();
            } else ans = "yes";

            answer.append(ans).append("\n");
        }
        System.out.println(answer);
    }
}
