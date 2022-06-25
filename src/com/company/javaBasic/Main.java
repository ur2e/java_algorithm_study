package com.company.javaBasic;

public class Main {
    public static void main(String[] args) {
        String str = "hi my name is ";
        int i = 0;
        int pos;
        while((pos = str.indexOf(" ")) != -1){
            System.out.println(str.charAt(i) + "  "+i);
            if(' ' == str.charAt(i))
                str = str.substring(i);
            i++;
        }
    }
}
