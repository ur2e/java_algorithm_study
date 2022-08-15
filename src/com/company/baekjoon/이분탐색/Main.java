package com.company.baekjoon.이분탐색;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] title = new String[n];
        int[] limit = new int[n];
        int[] arr = new int[m];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            title[i] = input[0];
            limit[i] = Integer.parseInt(input[1]);
        }
        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 마지막 상한선은 볼 필요가 없으니까 //
        for(int i = 0; i < n-1; i++){

            int lt = 0, rt = n-1;
            int mid = 0;
            while(lt <= rt){
                mid = (lt + rt) / 2;
                // limit가 작아질 때를 찾어?
                if(arr[mid] == limit[i]){
                    break;
                } else if(arr[mid] > limit[i]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }

            System.out.println(title[i] + " " + mid);
//            for(int k = 0; k < mid; k++){
//                sb.append(limit[i]+"\n");
//            }
        }


        System.out.println(sb);
    }
}
