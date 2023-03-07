package com.company.javaBasic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "/Users/yrji/workspace/study/java/src/com/company/javaBasic/test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;

            // FileInputStream을 이용해서 파일 내용을 읽고 화면에 출력한다.
            while((data=fis.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fis.close();

            // FileReader를 이용해서 파일 내용을 읽어 화면에 출력한다.
            while((data = fr.read()) != -1)
                System.out.print((char)data);

            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
