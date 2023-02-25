class Solution {
    public int solution(int n) {
        int start = 0;
        int end = 1;
        int sum = start + end;
        int count = 0;
        while (end <= n) {
            if (sum == n) {
                count++;
                end++;
                sum += end;
            } else if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            }
        }

        return count;
    }
}