package com.company.baekjoon.구현;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n = 0;

        try{
            n = Integer.parseInt(num, 8);
        }catch(Exception e){
            e.printStackTrace();
        }


        Stack<Integer> stack  = new Stack<>();
        while(n>0){
            stack.add(n % 2);
            n /= 2;

        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
