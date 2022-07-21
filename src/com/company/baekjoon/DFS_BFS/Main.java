package com.company.baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //static ArrayList<ArrayList<Integer>> arr;
    static List<Integer>[] arr;
    static int[] check;
    static int[] memo;
    int dfs (int n) {
        int cnt = 0;
        if(memo[n] != 0)    return memo[n];
        if(arr[n].size() == 0) {
            return 0;
        }
        else {
            for(int x : arr[n]) {
                cnt++;
                if(memo[x] != 0) {
                    cnt += memo[x];
                    continue;
                }
                else if (check[x] == 0) {
                    check[x] = 1;
                    memo[x] = dfs(x);
                    cnt += memo[x];
                    check[x] = 0;
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        memo = new int[n+1];
        check = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int cnt;
        for(int i = 1; i <= n; i++){
            check[i] = 1;
            cnt = T.dfs(i);
            map.put(i, cnt);
            max = cnt > max ? cnt: max;
        }

        for(int x : map.keySet()){
            System.out.println(x + " " + map.get(x));
            if(map.get(x) == max) sb.append(x + " ");
        }
        System.out.println(sb);
    }
}
