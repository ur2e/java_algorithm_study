package com.company.baekjoon.이분탐색.IF문좀대신써줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] title = new String[n];
        int[] limit = new int[n];
        int[] num = new int[m];

        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            limit[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < m; i++){

            int lt = 0, rt = n - 1;
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                if(limit[mid] < num[i]) lt = mid + 1;
                else rt = mid - 1;
            }
            sb.append(title[rt+1]).append("\n");
        }

        System.out.println(sb);

    }
}
