package com.company.java_algorithm_study.Section5_Stack_Queue.후위식연산;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 연산자 하나에 숫자 2개 필요하다.
        // 연산자가 나오면 숫자 두 개꺼네 .
        // 계산한 값은 다시 스택에 넣어
        Stack<Integer> stack = new Stack<>();
        String str = sc.nextLine();
        for(char x: str.toCharArray()){
            // 숫자라면 스택에 넣어
            if(Character.isDigit(x))    stack.push(x - '0');
            // 연산자라면 숫자 두 개 꺼내고, 계산해서 다시 넣어
            else {
                // 숫자 순서는 그대로 유지하기 위해서 먼저 뽑은 숫자를 b로 둔다.
                int b = stack.pop();
                int a = stack.pop();

                if(x == '+')    stack.push(a + b);
                else if(x == '-') stack.push(a - b);
                else if(x == '*') stack.push(a * b);
                else stack.push(a / b);
            }
        }

        System.out.println(stack.get(0));
    }
}
