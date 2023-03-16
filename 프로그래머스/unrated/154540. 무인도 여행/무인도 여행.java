import java.util.*;
class Solution {
    static List<Integer> answer = new ArrayList<>();
    static int width;
    static int height;
    static char[][] map ;// 지도
    static int[][] visited ;//방문여부 저장
    static int[] xdir={0,0,-1,1};
    static int[] ydir={-1,1,0,0};
    
    int bfs(int x, int y){
        int temp=map[x][y]-'0';
        for(int k=0;k<4;k++){//상하좌우 4방향
            int dx=x+xdir[k];
            int dy=y+ydir[k];
            if(dx >= 0 && dx < height && dy >= 0 && dy < width){
                if(visited[dx][dy] == 0 && map[dx][dy] != 'X'){
                    visited[dx][dy]=1;
                    temp+=bfs(dx,dy);    
                }
            } 
        }
        return temp;
    }
    
    public int[] solution(String[] maps) {
        width=maps[0].length();
        height=maps.length;
        map = new char[maps.length][];
        visited = new int[maps.length][maps[0].length()];
        
        //지도 초기화
        for(int i=0;i<maps.length;i++){
            map[i]=maps[i].toCharArray();
        }

        //지도에서 방문하지 않은 무인도를 방문 
         for(int i=0;i<maps.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j] != 'X' && visited[i][j]==0){
                    visited[i][j]=1;
                    int isLand=bfs(i,j);
                    if (isLand != 0) {
                        answer.add(isLand);
                    }
                }
            }
        }
        Collections.sort(answer);
        
        if(answer.isEmpty()){
            answer.add(-1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}