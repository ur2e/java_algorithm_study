import java.util.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] dx = {-1, 0, 1 ,0};
    int[] dy = {0, 1, 0, -1};
    
    int n, m;
    
    static int[][] map;
    Queue<Point> q = new LinkedList<>();
    
    public int BFS(int x, int y) {
        q.offer(new Point(x, y));
        int sum = map[x][y];
        map[x][y] = 0;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] > 0){
                    q.offer(new Point(nx, ny));
                    sum += map[nx][ny];
                    map[nx][ny] = 0;
                }
            }
        }
        
        return sum;
    }
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new int[n][m];
        
        List<Integer> ans = new ArrayList<>();
        
        
        for(int i = 0; i < n; i++) {
            // split 때문에 나는 런타임 에러도 아니었다.
            char[] tmp = maps[i].trim().toCharArray();
            for(int j = 0; j < m; j++) {
                if(tmp[j] == 'X') map[i][j] = 0;
                else { 
                    map[i][j] = tmp[j] - '0'; 
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     // split 때문에 나는 런타임 에러 아님
        //     char[] tmp = maps[i].toCharArray();
        //     for(int j = 0; j < m; j++) {
        //         if(tmp[j] == 'X') map[i][j] = 0;
        //         else { // 2. Integer.parseInt도 아님
        //             map[i][j] = Character.getNumericValue(tmp[j]); 
        //         }
        //     }
        // }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] > 0)  {
                    ans.add(BFS(i, j));
                }
            }
        }
        
        Collections.sort(ans);
        return ans.isEmpty()? new int[]{-1} : ans.stream().mapToInt(i -> i).toArray();
    }
}