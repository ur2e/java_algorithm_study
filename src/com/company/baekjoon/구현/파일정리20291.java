package com.company.baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파일정리20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> file = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            String extension = br.readLine().split("\\.")[1];
//            if(file.get(extension) == null) file.put(extension, 1);
//            else file.put(extension, file.get(extension) + 1);
//        }

        for (int i = 0; i < n; i++) {
            String extension = br.readLine().split("\\.")[1];
            file.put(extension, file.getOrDefault(extension, 0) + 1 );
        }

        List<String> keys = new ArrayList<>(file.keySet());
        Collections.sort(keys);

        for(String x : keys){
            System.out.println(x + " " + file.get(x));
        }
    }
}
