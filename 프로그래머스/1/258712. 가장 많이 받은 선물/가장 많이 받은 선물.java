import java.util.*;

class Solution {
    int[] expect;
    int answer = 0;
    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        int[][] table = new int[n+1][n+1];
        Map<String, Integer> nameIdx = new HashMap<>();
        expect = new int[n];
        
        for(int i = 0; i < n; i++) {
            nameIdx.put(friends[i], i);
        }
        
        for (String g : gifts) {
            int giver = nameIdx.get(g.split(" ")[0]);
            int reciver = nameIdx.get(g.split(" ")[1]);
            table[giver][reciver] += 1;
            table[giver][giver] += 1;
            table[reciver][reciver] -= 1;
        }
        
        for (int g = 0; g < n; g++) {
            for (int r = 0; r < g; r++) {
                if (g == r) continue; 
                
                if (table[g][r] == table[r][g]) { 
                    calScore(g , r, table[g][g], table[r][r]); 
                }
                
                calScore(g, r, table[g][r], table[r][g]);
            }
        }
        
        for (int score : expect) {
            answer = score > answer ? score : answer;
        }
        
        
        return answer;
    }
    
    private void calScore(int g, int r, int gScore, int rScore){
        if (gScore > rScore) {
            expect[g]++;
        } else if (gScore < rScore) {
            expect[r]++;
        } 
    }
    
}