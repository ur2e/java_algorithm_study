package com.company.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class 미해결 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        //ArrayList<Integer> arr1 = new ArrayList<>();
        //int[] arr = new int[num];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            //arr1.add(Integer.parseInt(st.nextToken()));
            //arr[i] = Integer.parseInt(st.nextToken());
            sb.append(st.nextToken());
        }

        num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            if(sb.indexOf(st.nextToken()) > -1) bw.write(1+"\n");
            else bw.write(0+"\n");
        }
        br.close();
        bw.close();
    }
}
