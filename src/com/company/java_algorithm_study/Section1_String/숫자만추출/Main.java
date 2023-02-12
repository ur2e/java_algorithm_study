package com.company.java_algorithm_study.Section1_String.숫자만추출;

public class Main {
    public static void main(String[] args) {
        String str = "sjf0ajf1jhh2jh0af5ecv";

        String numStr = str.replaceAll("[^0-9]", "");
        int n = Integer.parseInt(numStr);
        System.out.println("n = " + n);
    }
}
