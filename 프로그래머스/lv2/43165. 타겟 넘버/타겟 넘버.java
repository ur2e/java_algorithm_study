class Solution {   
    int dfs(int L, int sum, int target, int[] numbers) {
        if(L == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(L+1, sum + numbers[L], target, numbers) + dfs(L+1, sum - numbers[L], target, numbers);
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, target, numbers);
        
    }
}
