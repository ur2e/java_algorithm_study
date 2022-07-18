package com.company.baekjoon.구현;

public class Main {
    public static void main(String[] args) {
        String text = "file.txt";
//        String extension = text.split(".")[1];
//        String extension = text.split("\\.")[1];
//        System.out.println(extension);

        String[] tmp =text.split(""); // 한 글자씩
        String[] tt = text.split(".");
        String[] ttt = text.split("-"); // 없는 문자

        System.out.println(" ---- split(\"\") -----");
        for(String x: tmp){
            System.out.print(x + "  ");
        }

        System.out.println("\n ---- split(\".\") -----");
        for(String x: tt){
            System.out.print(x + "  ");
        }

        System.out.println("\n ---- split(\"-\") -----");
        for(String x: ttt){
            System.out.print(x + "  ");
        }
    }
}
