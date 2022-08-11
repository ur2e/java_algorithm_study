package com.company.java_algorithm_study.section9_greedy.결혼식;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int time;
    public char state;

    Time(int time, char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time ob) {
        if(this.time == ob.time)   return this.state - ob.state;
        else return this.time - ob.time;
    }
}
public class Main {
    public int solution(ArrayList<Time> arr, int n){
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;

        for(Time ob: arr) {
            System.out.println(ob.time + " " + ob.state);
        }

        for(Time ob: arr){
            if(ob.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = sc.nextInt(); // startTime
            int eT = sc.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }

        System.out.println(T.solution(arr, n));
    }
}
