package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date.toString());

        // Date 원하는 형태로 출력하기
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println(ft.format(date));

        // 현재시간을 Long 타입의 값으로 구하기  1
        System.out.println(date.getTime());
        long start = date.getTime();

        // 현재시간을 Long 타입의 값으로 구하기  2
        long startS = System.currentTimeMillis();

        // 실행시간 구하기
        Thread.sleep(5000);

        long end = date.getTime();
        long endS = System.currentTimeMillis();

        System.out.println("---------------------------------------");
        System.out.println("endS = " + endS);
        System.out.println("startS = " + startS);
        System.out.println("endS-startS = " + (endS - startS) );
        System.out.println("end = " + end);
        System.out.println("start = " + start);
        System.out.println("end-start = " + (end - start) );
        
        
        System.out.println("실행시간 : " + (end - start)/1000 + "초"); // 0
        System.out.println("실행시간 : " + (endS - startS)/1000 + "초"); // 5 
        /*
            System.currentTimeMillis()로 실행 시간 구하기

            long start = System.currentTimeMillis();
            Thread.sleep(5000);
            long end = System.currentTImeMillis();
            sout("실행시간 : " + (end-start)/1000 + "초");
         */
    }
}
