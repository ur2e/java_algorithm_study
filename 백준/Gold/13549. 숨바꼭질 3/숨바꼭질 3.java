
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int x, L;
    Pos(int x, int L){
        this.x = x;
        this.L = L;
    }
}

public class Main {
    static boolean[] visited;
    static int k, answer=Integer.MAX_VALUE;
    final static int MAX = 100000;

    private void bfs(int x){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, 0));

        while(!q.isEmpty()){
            Pos curr = q.poll();
            visited[curr.x] = true;

            if (curr.L > answer)    break;

            if(curr.x == k) {
                answer = Math.min(curr.L, answer);
            }

            int nx = curr.x * 2;
            if(nx <= MAX && !visited[nx])   {
                q.offer(new Pos(nx, curr.L));
            }

            nx = curr.x - 1;
            if(nx >=0  && !visited[nx])   {
                q.offer(new Pos(nx, curr.L+1));
            }

            nx = curr.x + 1;
            if(nx <= MAX && !visited[nx])   {
                q.offer(new Pos(nx, curr.L+1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];

        T.bfs(n);
        System.out.println(answer);
    }
}
