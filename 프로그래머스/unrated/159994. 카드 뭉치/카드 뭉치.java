class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
 
        int idx1=0, idx2=0, idxG=0;
        int len1 = cards1.length, len2 = cards2.length, n=goal.length;
        
        for(int i = 0; i < n; i++){
            if(idx1 < len1 && cards1[idx1].equals(goal[i])) idx1++;
            else if(idx2 < len2 && cards2[idx2].equals(goal[i])) idx2++;
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}