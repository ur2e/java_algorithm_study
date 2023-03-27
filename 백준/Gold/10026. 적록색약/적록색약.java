
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int n;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void dfsNormal(int x, int y, char c){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && c == map[nx][ny]) {
                visited[nx][ny] = true;
                dfsNormal(nx, ny, c);
            }
        }
    }

    private void dfs(int x, int y, char c){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny]) {
                if(c == 'B' && map[nx][ny] != 'B') continue;
                if(c != 'B' && map[nx][ny] == 'B')  continue;
                visited[nx][ny] = false;
                dfs(nx, ny, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

       int answerN=0, answer=0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    T.dfsNormal(i, j, map[i][j]);
                    answerN++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]){
                    visited[i][j] = false;
                    T.dfs(i, j, map[i][j]);
                    answer++;
                }
            }
        }


        System.out.println(answerN + " " + answer);
    }
}
