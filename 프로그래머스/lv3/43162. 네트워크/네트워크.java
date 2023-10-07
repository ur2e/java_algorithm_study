import java.util.*;

class Solution {
    int[] arr;
    private int find(int x){
        if (arr[x] == x) return x;
        else 
            return arr[x] = find(arr[x]);
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x < y) {
            arr[y] = x;
        }
        else {
            arr[x] = y;
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        arr = new int[n];
            
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j)  continue;
                if (computers[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        
        Set<Integer> parent = new HashSet<>();
        parent.add(arr[0]);
        
        for(int i = 1; i < n; i++){
           find(i);
        }
        
        for(int i = 1; i < n; i++){
            parent.add(arr[i]);
        }
        
        return parent.size();
    }
}