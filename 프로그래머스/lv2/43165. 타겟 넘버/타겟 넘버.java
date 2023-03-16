class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) { // 모든 숫자에 대해 더하거나 뺀 경우
            if(sum == target) { // 합이 타겟과 같은 경우
                return 1; // 방법의 수 1 증가
            }
            return 0;
        }
        
        // 현재 숫자를 더하는 경우와 빼는 경우에 대해 DFS 수행
        int cnt = 0;
        cnt += dfs(numbers, target, index+1, sum+numbers[index]); // 더하는 경우
        cnt += dfs(numbers, target, index+1, sum-numbers[index]); // 빼는 경우
        return cnt;
    }
}