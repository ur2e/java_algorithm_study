

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] ch = new int[100001];
    static int n, k;
    static int answer = Integer.MAX_VALUE, sameCase = 0;
    static class Node {
        int x;
        int L;
        Node (int x, int L) {
            this.x = x;
            this.L = L;
        }
    }
    static void bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        ch[n] = 1;
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.L > answer) return ;

            if (curr.x == k) {
                answer = Math.min(curr.L, answer);
                if (answer == curr.L) {
                    sameCase++;
                }
            }

            else if(curr.L < answer){
                ch[curr.x] = 1;
                int nx = curr.x + 1;
                if( nx <= 100000 && ch[nx] == 0){
                    q.offer(new Node(nx, curr.L + 1));
                    //System.out.println("+1 " + curr.x + " " + curr.L + " " + nx + " " + (curr.L+1));
                }

                nx = curr.x - 1;
                if(nx >= 0 && ch[nx] == 0){
                    q.offer(new Node(nx, curr.L + 1));
                    //System.out.println("-1 " + curr.x + " " + curr.L + " " + nx + " " + (curr.L+1));
                }

                nx = curr.x * 2;
                if(nx <= 100000 && ch[nx] == 0){
                    q.offer(new Node(nx, curr.L + 1));
                    //System.out.println("*2 " + curr.x + " " + curr.L + " " + nx + " " + (curr.L+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        System.out.println(answer);
        System.out.println(Math.max(sameCase, 1));
    }
}
