

import java.util.*;

public class Main {
    static int[] parent;

    private int find(int x){
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return x;
    }

    private void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a > b){
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시의 수
        int m = sc.nextInt(); // 여행 계획에 속한 도시들의 수

        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(sc.nextInt() == 1) {
                    T.union(i, j);
                }
            }
        }


        int set = T.find(sc.nextInt());
        String answer = "YES";

        for (int i = 1; i < m; i++) {
            if(set != T.find(sc.nextInt())){
                answer = "NO";
            }
        }

        System.out.println(answer);
    }
}

