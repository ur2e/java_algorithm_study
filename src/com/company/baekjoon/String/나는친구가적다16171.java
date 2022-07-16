package com.company.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나는친구가적다16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //읽어오면서 바로 replaceAll 적용가능
        String str = br.readLine().replaceAll("\\d", "");
        String keyword = br.readLine();

        System.out.println(str.contains(keyword)? 1: 0);

        /*

        String str = br.readLine();
        String keyword = br.readLine();

        str = str.replaceAll("[0-9]","");
        if(str.contains(keyword)) System.out.println(1);
        else System.out.println(0);
        * */
    }
}
