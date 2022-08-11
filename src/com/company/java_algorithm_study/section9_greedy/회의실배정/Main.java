package com.company.java_algorithm_study.section9_greedy.회의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int s, e;
    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o){
        // 끝나는 시간으로 오름차순 정렬
        // 끝나는 시간이 같으면 시작 시간으로 오름차순 정렬
        if(this.e == o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}
public class Main {
    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        int et = 0; // end time
        Collections.sort(arr);

        for(Time ob: arr) {
            if(ob.s >= et){
                cnt++;
                et = ob.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Time(x, y));
        }
        System.out.println(T.solution(arr ,n));
    }
}
