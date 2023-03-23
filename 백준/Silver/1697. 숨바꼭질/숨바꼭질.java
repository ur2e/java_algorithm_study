
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
    static int k;
    final static int MAX = 100000;

    private int bfs(int x){
        int answer = 0;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, 0));
        visited[x] = true;

        if(x == k)  return 0;

        while(!q.isEmpty()){
            Pos curr = q.poll();
            if(curr.x == k) {
                answer = curr.L;
                break;
            }

            else{
                if(curr.x * 2 <= MAX && !visited[curr.x*2]){
                    visited[curr.x*2] = true;
                    q.offer(new Pos(curr.x*2, curr.L+1));
                }
                if(curr.x + 1 <= MAX && !visited[curr.x+1]){
                    visited[curr.x+1] = true;
                    q.offer(new Pos(curr.x+1, curr.L+1));
                }
                if(curr.x - 1 >= 0 && !visited[curr.x-1]){
                    visited[curr.x-1] = true;
                    q.offer(new Pos(curr.x-1, curr.L+1));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];

        System.out.println(T.bfs(n));
    }
}
