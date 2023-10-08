import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
    
        int[][] dist = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0});
        int L = 1;
        while(!q.isEmpty()){
            L++;
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] c = q.poll();
                for(int k = 0; k < 4; k++){
                    int nx = c[0] + dx[k];
                    int ny = c[1] + dy[k];
                    if(nx >= 0 && nx < n && ny >=0 && ny < m && maps[nx][ny] == 1){
                        dist[nx][ny] = L;
                        maps[nx][ny] = 0;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        if (dist[n-1][m-1] == 0)    return -1;
        else return dist[n-1][m-1];
    }
}