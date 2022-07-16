/*
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String curTime = sc.next();
        String natriumThrowingTime = sc.next();

        sc.close();

        if (curTime.equals(natriumThrowingTime)) {
            System.out.print("24:00:00");
            System.exit(0);
        }

        int h = Integer.parseInt(natriumThrowingTime.split(":")[0]) - Integer.parseInt(curTime.split(":")[0]);
        int m = Integer.parseInt(natriumThrowingTime.split(":")[1]) - Integer.parseInt(curTime.split(":")[1]);
        int s = Integer.parseInt(natriumThrowingTime.split(":")[2]) - Integer.parseInt(curTime.split(":")[2]);

        if (s < 0) {
            s += 60;
            --m;
        }

        if (m < 0) {
            m += 60;
            --h;
        }

        if (h < 0) {
            h += 24;
        }

        System.out.format("%02d:%02d:%02d", h, m, s);
    }

}
*/

package com.company.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경고3029_다시보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int nowHH = Integer.parseInt(st.nextToken());
        int nowMM = Integer.parseInt(st.nextToken());
        int nowSS = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ":");
        int planHH = Integer.parseInt(st.nextToken());
        int planMM = Integer.parseInt(st.nextToken());
        int planSS = Integer.parseInt(st.nextToken());

        int HH = planHH - nowHH;
        int MM = planMM - nowMM;
        int SS = planSS - nowSS;

        if(HH < 0) HH += 24;
        if(MM < 0) {
            MM += 60;
            HH -= 1;
        }
        if (SS < 0) {
            SS += 60;
            MM -= 1;
            if(MM < 0) {
                MM += 60;
                HH -= 1;
                if (HH < 0) HH += 24;
            }
        }
        if( HH == 0 && MM == 0 && SS == 0){
            sb.append("24:00:00");
        } else {
            sb.append(String.format("%02d", HH)).append(":").append(String.format("%02d", MM)).append(":").append(String.format("%02d", SS));
        }
        System.out.println(sb);

    }
}

