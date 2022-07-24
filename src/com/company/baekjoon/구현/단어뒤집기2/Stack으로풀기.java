package com.company.baekjoon.구현.단어뒤집기2;

import java.io.*;
import java.util.*;

public class Stack으로풀기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // < 들어오면 stack에 저장되어 있는 것들을 먼저 출력. stack 빌 때까지
        // > 들어오면 그대로 출력 == 태그 안에 있으면 문자열 그대로 출력
        // 태그 밖 공백 or < 이 오면 스택이 빌 때까지 pop하여 출력
        // 태그 밖 공백 아니면 스택에 넣어

        boolean inout = false;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char x: str.toCharArray()){
            // <
            if(x == '<') {
                inout = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(x);
            }
            else if(x == '>'){
                inout = false;
                sb.append(x);
            }
            else if(inout) sb.append(x);
            else if(!inout) {
                if(x == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
                else {
                    stack.push(x);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.append(' ');
        System.out.println(sb);
    }
}
