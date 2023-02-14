package com.company.java_algorithm_study.Section1_String.가장짧은문자거리;

import java.util.Scanner;

public class Main {
    private int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int p = 1000; // p는 타겟문자와의 거리, 최솟값이 되어야하므로 큰 값으로 초기화해준다.

        // 오른쪽 방향으로 탐색하며 answer 배열에 p를 저장한다.
        for (int i = 0; i < s.length(); i++) {
            // 문자열의 각 문자와 타겟 문자가 같다면 p(타겟문자와의 거리)는 0이다
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }


        // 왼쪽 방향으로 탐색 시작
        p = 1000;
        for (int i = s.length()-1; i >= 0 ; i--) {
            if (s.charAt(i) == t) p = 0; // 이미 answer 배열에는 0이 저장되어있으니 answer[i] = p; 생략
            else {
                p++;
                answer[i] = Math.min(answer[i], p); // 더 작은 p 값으로 교체
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        /*
            문자열 "tearchermode", 문자 e가 주어졌을 때 문자열의 각 문자가 문자 e와 떨어진 거리 구하기

            먼저, 문자 간 거리를 나타내는 변수 p와
            문자 간 최단 길이를 저장하는 int 배열 answer을 생성한다.
            p는 문제 조건을 확인한 후 가장 큰 값으로 둔다. Ex. p=1000

            문자열을 오른쪽 방향으로 탐색하여 문자 e가 아니면 p를 1 증가시키고 answer[idx]에 저장
            왼쪽 방향도 동일하게 진행하다가 answer[idx](기존값) > p 라면 answer[idx]를 p로 교체한다.

            오른쪽, 왼쪽 방향으로 두 번 탐색을 진행하는 이유
            - 오른쪽 방향 탐색은 왼쪽 e와의 거리만 탐색할 수 있다.
            - 왼쪽 방향 탐색은 오른쪽 e와의 거리만 탐색할 수 있다.
            - 한 방향으로만 탐색하여 문자 거리를 계산하면 최솟값이 될 수 없기 때문에 양쪽 뱡향을 모두 탐색하여 값을 업데이트 한다.
         */
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int x: T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}