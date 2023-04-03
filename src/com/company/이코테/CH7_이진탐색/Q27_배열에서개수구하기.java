package com.company.이코테.CH7_이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q27_배열에서개수구하기 {
    private static int leftIdx(int x, int[] arr) {
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start + end) / 2;
            System.out.println("left ::" + start + " "  + end + " " +mid + " " + arr[mid]);
            if(arr[mid] >= x)   end = mid;
            else start = mid + 1;
        }

        return end;
    }

    private static int rightIdx(int x, int[] arr){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > x)   end = mid;
            else start = mid + 1;
        }

        return end;
    }
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int answer = -1;

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int left = leftIdx(x, num);
        int right = rightIdx(x, num);
        System.out.println(left +  " " + num.length);

        System.out.println(right - left == 0? -1 : right-left);
    }
}
/*
7 2
1 1 2 2 2 2 3
 */