

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int sum;

    static void dfs(int x, int y) {
        sum++;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[ny][nx]) {

                //System.out.println(x+ " " + y + " bfs 들어가용 ("+nx+", "+ny+")   ");
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lbX = Integer.parseInt(st.nextToken());
            int lbY = Integer.parseInt(st.nextToken());

            int rtX = Integer.parseInt(st.nextToken());
            int rtY = Integer.parseInt(st.nextToken());

            for(int x=lbX; x < rtX; x++) {
                for(int y= lbY; y < rtY; y++){
                    visited[y][x] = true;
                }
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (visited[i][j]) {
//                    System.out.print("0");
//                }
//                else {
//                    System.out.print(".");
//                }
//            }
//            System.out.println();
//        }


        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[j][i]) {
                    sum = 0;
                    //System.out.println("지금 점부터 탐색 시작 " + i + " " + j);
                    dfs(i, j);
                    //System.out.println("sum = " + sum);
                    ans.add(sum);
                }
            }
        }

        Collections.sort(ans);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans.size()+"\n");
        for (int i = 0; i < ans.size(); i++) {
            bw.write(ans.get(i) +" ");
        }
        br.close();
        bw.close();

    }
}