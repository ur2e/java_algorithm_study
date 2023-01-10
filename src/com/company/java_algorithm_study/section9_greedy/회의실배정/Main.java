//package com.company.java_algorithm_study.section9_greedy.회의실배정;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//
//class Time implements Comparable<Time>{
//    int s;
//    int e;
//
//    Time(int s, int e){
//        this.s = s;
//        this.e = e;
//    }
//
//    @Override
//    public int compareTo(Time o){
//        if(this.e == o.e)   return this.s - o.s; // 오름차순 정렬
//        else return this.e - o.e;
//    }
//
//}
//
//public class Main {
//    public int solution(ArrayList<Time> arr, int n){
//        int cnt = 0;
//        Collections.sort(arr);
//        int endTime = 0; // 현재 회의에서 끝나는 시간
//        for(Time ob: arr){
//            if(ob.s >= endTime) {
//                cnt++;
//                endTime = ob.e;
//            }
//        }
//
//        return cnt;
//    }
//
//    public static void main(String[] args) throws IOException {
//        Main T = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        ArrayList<Time> arr = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String[] temp = br.readLine().split(" ");
//            arr.add(new Time(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
//        }
//        System.out.println(T.solution(arr, n));
//    }
//}
