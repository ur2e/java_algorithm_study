import java.util.*;

class Solution {
    boolean[] visited;
    
    private void dfs(int x, int[][] computers){
        visited[x] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i] && computers[x][i] == 1){
                dfs(i, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (!visited[i] && computers[i][j] == 1) {
                    dfs(i, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}