class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux = 51, luy = 51, rdx = -1, rdy = -1;
        
        int n = wallpaper.length;
        int len = wallpaper[0].length();
        for(int i = 0; i < n; i++) {
            char[] arr = wallpaper[i].toCharArray();
            
            for(int j = 0; j < len; j++) {
                if(arr[j] == '#') {
                    lux = Math.min(i, lux);
                    luy = Math.min(j, luy);
                    rdx = Math.max(i, rdx);
                    rdy = Math.max(j, rdy);
                }
            }
        }
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}