class Solution {
    int len = 0;
    int answer = 0;
    
    void dfs(int L, int sum, int target, int[] numbers) {
        if(L == len){
            if(sum == target){
                answer++;
            }
        } else{
            dfs(L+1, sum-numbers[L], target, numbers);
            dfs(L+1, sum+numbers[L], target, numbers);
        }
    }
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        dfs(0, 0, target, numbers);
        return answer;
    }
}