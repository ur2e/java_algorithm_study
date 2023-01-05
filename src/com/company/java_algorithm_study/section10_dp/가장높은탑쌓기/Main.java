package com.company.java_algorithm_study.section10_dp.가장높은탑쌓기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int s, h, w;

    Brick(int s, int h, int w){
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o){
        return o.s - this.s;
    }
}

public class Main {
    static int[] dy;
    public int solution(ArrayList<Brick> arr){
        int answer = 0;
        Collections.sort(arr); // arr 배열을 넓이에 의해서 내림차순
        dy[0] = arr.get(0).h; // 첫번째 블록은 자기 자신의 높이를 가짐
        answer = dy[0]; // 첫번째 블록만 쌓을 수 있는 경우를 고려
        for (int i = 1; i < arr.size(); i++) {
            int maxH = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr.get(j).w >= arr.get(i).w && dy[j] > maxH) {
                    maxH = dy[j];
                }
            }
            dy[i] = maxH + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[n]; // 블록의 최대 높이를 저장할 dy 배열 초기화
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }

        System.out.println(T.solution(arr));
    }
}