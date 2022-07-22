package com.company.baekjoon.구현.오리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static char[] sound = {'q', 'u', 'a', 'c', 'k'};
    static class Duck {
        int idx;
        Duck(int idx){
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        ArrayList<Duck> ducks = new ArrayList<>();
        int answer = 0;
        boolean noanswer = false;
        // q 자리가 아닌데 q가 오면 count를 추가.
        // 오리 클래스 만들어서 현재 오리가 가지고 있어야하는 알파벳 저장?

        // 이상한자리에 q가 추가 -> duck 추가 (X)
        // q가 추가되면 duck을 추가하되,
        // 모든 duck의 idx가 5라면 duck 추가 안하고 그냥 문자열 확인만 하면된다.

        // for문으로 오리들 돌려서 오리들의 idx 값이랑 같은지 확인
            // 같으면 정상 -> idx++ 해주자 // 다르면 -1 출력

        // 초기화
        if (input[0] != 'q') answer = -1;
        else {


            ducks.add(new Duck(1));

            for (int i = 1; i < input.length; i++) {
                boolean find = false;
                for (Duck d : ducks) {
                    // 정상
                    if (input[i] == sound[d.idx]) {
                        //System.out.println("1번 "+input[i] + " "+ sound[d.idx] + " " + d.idx );
                        d.idx++; // 다음 문자 받을 준비
                        if (d.idx == 5) d.idx = 0;
                        find = true;
                        break;
                    }
//                    } else if (input[i] == 'q' && d.idx == 0) {
//                        //System.out.println("2번 "+input[i] + " "+ sound[d.idx] + " " + d.idx );
//                        d.idx = 1;
//                        find = true;
//                        break;
//                    }
                }
                if(!find) {
                    if(input[i] == 'q') {
                        ducks.add(new Duck(1));
                    } else {
                        noanswer = true;
                        break;
                    }
                }
            }
            answer = ducks.size();
        }
        for(Duck d : ducks){
            if(d.idx != 0) noanswer=true;
        }


        System.out.println(answer = noanswer? -1 : answer);
    }
}
