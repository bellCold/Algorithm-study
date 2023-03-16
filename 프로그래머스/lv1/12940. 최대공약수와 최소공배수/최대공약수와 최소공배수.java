class Solution {
    public int[] solution(int n, int m) {
        int max = 0;
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                max = i;
            }
        }
        return new int[]{max, max * (n / max) * (m / max)};
    }
}