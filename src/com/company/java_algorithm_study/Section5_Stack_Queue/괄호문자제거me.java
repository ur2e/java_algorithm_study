package com.company.java_algorithm_study.Section5_Stack_Queue;

import java.util.*;

public class 괄호문자제거me {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(x == '(')    stack.push(x);
            else if(x == ')') stack.pop();
            else {
                if(!stack.isEmpty()){
                    str = str.replace(String.valueOf(str.charAt(str.indexOf(x))), "");
                }
            }
        }
        str = str.replace("(", "");
        str = str.replace(")", "");
        System.out.println(str);
    }
}
