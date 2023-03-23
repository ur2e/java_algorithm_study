
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int wolf = 0, sheep = 0;
    static char[][] map;
    static boolean[][] visited;
    static int n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void bfs(Pos pos){
        int o = 0, v = 0;
        Queue<Pos> q = new LinkedList<>();
        q.offer(pos);
        visited[pos.x][pos.y] = true;

        while(!q.isEmpty()){
            Pos curr = q.poll();

            if(map[curr.x][curr.y] == 'o')  o++;
            if(map[curr.x][curr.y] == 'v')  v++;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx > 0 && nx < n && ny > 0 && ny < m && map[nx][ny] != '#' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
        if(o > v)   sheep += o;
        else    wolf += v;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != '#' && !visited[i][j]){
                    T.bfs(new Pos(i, j));
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }
}
