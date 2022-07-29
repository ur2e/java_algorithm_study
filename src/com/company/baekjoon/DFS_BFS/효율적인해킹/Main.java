package com.company.baekjoon.DFS_BFS.효율적인해킹;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    //static List<Integer>[] list;
    static int[] ch;
    int dfs(int i){
        if(arr.get(i).size() == 0) {
            return 0;
        } else {
            int count = 0;
            ch[i] = 1;
            //for(int x : list[i]){
            for(int x: arr.get(i)){
                if(ch[x] == 0) {
                    ch[x] = 1;
                    count++;
                    count = count + dfs(x);
                }
            }
            return count;
        }
    }

    int bfs(int i){
        if(arr.get(i).size() == 0) return 0;
        else {
            int count = 0;
            Queue q = new LinkedList<Integer>();
            q.add(i);
            ch[i] = 1;
            while(!q.isEmpty()){
                int num = (int) q.poll();
                count++;
                for(int x: arr.get(num)){
                    if(ch[x] == 0){
                        ch[x] = 1;
                        q.add(x);
                    }
                }
            }
            return count;
        }
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ch = new int[n+1];
        arr = new ArrayList<ArrayList<Integer>>();
        //list = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            //list[i] = new ArrayList<Integer>();
            arr.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(b).add(a);
            //list[b].add(a);
        }

        int count[] = new int[n+1];
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            ch = new int[n+1];
            int cnt = T.bfs(i);
            count[i] = cnt;
            if(cnt > max) {
                max = cnt;
            }
        }
        for(int i = 1; i <= n; i++) {
            if(count[i] == max) sb.append(i + " ");
        }
        bw.write(String.valueOf(sb).trim());
        bw.flush();
    }
}
