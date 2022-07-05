package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LRU {
    static ArrayList<Integer> cache;
    static int s;
    static void cacheHit(int n){
        // 숫자 맨 앞으로 보내고, 다른 숫자들은 뒤로 보내기
//        int idx = cache.indexOf(n);
//        cache.remove(idx);

        cache.remove((Integer) n);
        cache.add(0, n);
        if(cache.size() > s) cache.remove(s);

        //for(int x : cache) System.out.print(x + " ");
    }

    static void cacheMiss(int n){
        cache.add(0, n);
        if(cache.size() > s) cache.remove(s);
        //for(int x : cache) System.out.print(x + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //int[] cache = new int[s];
        cache = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            cache.add(0);

        }
        // 입력 한 번마다 출력
        // null이면 0 출력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(st.nextToken());
            if(cache.contains(input))   cacheHit(input);
            else cacheMiss(input);
            //System.out.println();
        }

        for(int x : cache) System.out.print(x + " ");
    }
}
