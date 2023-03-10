package com.company.java_algorithm_study.section9_greedy.최대수입스케줄_PQ;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {

    int money;
    int time;

    Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture ob) {
        return ob.time - this.time; // 매개변수 - this = 내림차순
    }
}

public class Main {
    // 1. PQ 자료구조를 생성한다.
    // 2. 입력이 들어오면 lecture {money, time} 객체를 ArrayList에 저장
    // 3. 시간에 의해서 내림차순 정렬한다.
    // 4. 가장 큰 날짜를 max에 저장하고, 3일째, 2일째, 1일째처럼 역순으로 탐색한다.
    // 5. 정렬된 arrayList를 탐색하며 3일째에 해당하는 momey를 PQ에 넣는다. 다른 날짜를 만나면 멈춘다.
    // 6. 2일 째 탐색 전에 가장 큰 money를 poll한다. 2일째를 탐색하며 1일째를 만날 때 또 멈춘다.
    // 7. 가장 큰 값을 poll한다.

    // 날짜를 거꾸로 돌리는 이유
    // : 3일 안에 와야하는 스케줄을 먼저 넣고 나중에  2일, 1일의 수입을 한 번에 파악할 수 있다.
    static int n, max=Integer.MIN_VALUE;
    private int solution(ArrayList<Lecture> arr){
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 가장 큰 값을 우선순위로하는 PQ
        Collections.sort(arr); // time에 의해 정렬됨

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for( ; j < n; j++){ // j 초기화 식 생략
                System.out.println("i= " + i + ", j= "+j);
                if(arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money); // 날짜에 해당하는 수입을 넣어
            }
            if(!pQ.isEmpty()) answer += pQ.poll(); // 이거 까먹지 말자
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }

        System.out.println(T.solution(arr));
    }
}
