package com.company.java_algorithm_study.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public String solution(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if( x == ')'){
                while(stack.pop() != '(');
            }
            else {
                stack.push(x);
            }
        }
        for(int i = 0; i < stack.size(); i++){
            answer += stack.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        괄호문자제거 T = new 괄호문자제거();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }


}
