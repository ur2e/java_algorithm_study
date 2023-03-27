

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy= {1, 0, -1, 0};
    static int n;
    static int[][] map, visited;

    static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int dfs(Pos pos){
        int sum = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(pos);
        visited[pos.x][pos.y] = 1;
        while(!q.isEmpty()){
            Pos c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    q.offer(new Pos(nx, ny));
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] in = br.readLine().split("");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && visited[i][j] == 0){
                    ans.add(dfs(new Pos(i, j)));
                    cnt++;
                }
            }
        }

        Collections.sort(ans);

        System.out.println(cnt);
        for(int x: ans){
            System.out.println(x);
        }
    }
}
