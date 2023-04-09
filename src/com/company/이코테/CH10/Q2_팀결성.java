package com.company.이코테.CH10;

import java.util.Scanner;

public class Q2_팀결성 {
    static int[] parent;

    private static int find_parent (int x){
        // 루트 노드 아니라면, 재귀 호출로 루트 찾기
        if (x != parent[x]) {
            return find_parent(parent[x]);
        }
        return x;
    }

    private static void union_parent (int x, int y){
        x = find_parent(x);
        y = find_parent(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }

    public static void main(String[] args) {
        Q2_팀결성 T = new Q2_팀결성();
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 학생 번호
        int m = sc.nextInt(); // 연산의 개수

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();

            // 팀 합치기
            if (type == 0) {
                union_parent(x, y);
            }
            // 같은 팀 여부 확인 YES / NO
            else {
                if(find_parent(x) == find_parent(y)){
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
