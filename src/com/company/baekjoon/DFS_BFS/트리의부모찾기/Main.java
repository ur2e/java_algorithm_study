package com.company.baekjoon.DFS_BFS.트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static  ArrayList<ArrayList<Integer>> arr;
    static int[] answer;
    void bfs(int n){

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()){
            int next = q.poll();
            for(int x: arr.get(next)){
                if(answer[x] == 0){
                    answer[x] = next;
                    q.offer(x);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        answer = new int[n+1];
        for(int i = 0; i <= n; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 1; i <= n-1; i++){
            String[] line = br.readLine().split(" ");
            arr.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            arr.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }

        T.bfs(1);
        for(int i = 2; i <= n; i++){
            System.out.println(answer[i]);
        }




    }
}
