class Solution {
    public int solution(int a, int b, int n) {
        int[] dp = new int[1000001];
        int[] total = new int[1000001];
        dp[1] = n;
        total[1] = n;
        
        int count = 2;
        while (n / a >= 1) {
            dp[count] = (total[count - 1] / a) * b;
            total[count] = dp[count] + total[count - 1] % a;
            n = total[count];
            count++;
        }

        int answer = 0;

        for (int i = 2; i < 100000; i++) {
            answer += dp[i];
        }
        return answer;
    }
}