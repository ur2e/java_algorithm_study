package com.company.java_algorithm_study.Section6_Sorting_Searching.좌표정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 이제 여기서 정렬기준을 잡아준다.
    @Override
    public int compareTo(Point o){
        // x가 같을 경우
        // this.y - o.y  : 오름차순 ... ?
        if(this.x == o.x)   return this.y - o.y;
        else return this.x - o.x;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // Point class라는 객체 생성
            arr.add(new Point(x, y));
        }
        // sort 호출 -> Comparable 인터페이스 통해서 Point를 정렬한다.
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x + " " + o.y);
    }
}
