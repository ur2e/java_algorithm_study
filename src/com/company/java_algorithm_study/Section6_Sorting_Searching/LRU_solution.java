package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.util.*;
public class LRU_solution {
    public int[] solution(int size, int n, int[] arr){
        int[] cache = new int[size];

        for(int x: arr) {
            // hit된 값의 인덱스를 저장하는 변수
            int pos = -1;
            for(int i = 0; i < size; i++) if(x==cache[i]) pos=i;

            // Cache Miss 상황
            if(pos == -1) {
                for(int i = size-1; i >=1; i--){
                    cache[i] = cache[i-1];
                }
            } else{
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }

        return cache;
    }
    public static void main(String[] args){
        LRU_solution  T = new LRU_solution ();
        Scanner kb = new Scanner(System.in);
        int s=kb.nextInt();
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=kb.nextInt();
        for(int x : T.solution(s, n, arr)) System.out.print(x+" ");
    }
}