package com.company.baekjoon.이분탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Answer {
    static int m;
    static int n;
    static List<Item> list= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < n; i++){
            s = br.readLine();
            st = new StringTokenizer(s, " ");

            // list( title, limit)
            list.add(new Item(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i < m; i++){
            s = br.readLine();
            sb.append(list.get(binarySearch(Integer.parseInt(s))).title).append('\n');
        }

        System.out.println(sb.toString().trim());
    }

    static int binarySearch(int stat){

        int userStat = stat;
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = (left+ right) / 2;

            //limit보다 mid 값이 크면
            // 값을 낮춰줄 수 있도록 right를 줄여준다.
            if(userStat <= list.get(mid).limit) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
    static class Item {
        String title;
        int limit;

        public Item(String title, int limit) {
            this.title = title;
            this.limit = limit;
        }
    }
}
