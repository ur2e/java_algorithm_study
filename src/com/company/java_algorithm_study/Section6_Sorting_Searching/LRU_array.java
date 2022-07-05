package com.company.java_algorithm_study.Section6_Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LRU_array {
    static int[] arr;
    static int S;
    static void hit(int idx, int n){
        // 숫자 맨 앞으로 보내고, 다른 숫자들은 뒤로 보내기
        for(int i = idx-1; i >= 0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = n;
    }

    static void miss(int n){
        for(int i = S-2; i >= 0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //int[] cache = new int[s];
        arr = new int[S];
        for(int i = 0 ; i < S; i++){
            arr[i] = 0;
        }

        boolean isMiss = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(st.nextToken());

            for(int j = 0; j < S; j++) {
                if(arr[j] == input) {
                    isMiss = false;
                    hit(j, input);
                    break;
                }
            }
            if(isMiss) miss(input);
            isMiss = true;
        }

        for(int x: arr) System.out.print(x + " ");
    }
}
