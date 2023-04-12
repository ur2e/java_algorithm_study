
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Edge {
    int x, y;
    int cost;
    Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class Main {
    static int[] parent;

    private static int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a > b)   parent[a] = b;
        else        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 간선의 수

        Edge[] edges = new Edge[m];

        // MST -> Greedy + UF -> parent 배열 생성 후 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }

        // cost 값 오름차순 정렬 for Greedy
        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        int answer = 0;
        for (Edge e : edges) {
            int a = find(e.x);
            int b = find(e.y);

            if (a != b) {
                union(a, b);
                answer += e.cost;
            }

        }

        System.out.println(answer);
    }
}
