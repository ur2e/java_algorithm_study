import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt(); // 현재 위치
        int g = sc.nextInt(); // 면접장 위치
        int u = sc.nextInt();
        int d = sc.nextInt();

        int[] visited = new int[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = 1;

        int L = 0;
        int answer = -1;
        while(!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int curr = q.poll();
                if(curr == g)   {
                    answer = L;
                    break;
                }

                int nx = curr + u;
                if(nx > 0 && nx <= f && visited[nx] == 0) {
                    q.offer(nx);
                    visited[nx] = 1;
                }

                nx = curr - d;
                if(nx > 0 && nx <= f && visited[nx] == 0) {
                    q.offer(nx);
                    visited[nx] = 1;
                }
            }
            L++;
        }

        String result;
        System.out.println(answer == -1 ? "use the stairs" : answer);
    }
}
