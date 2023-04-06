class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        if (n == 1) {
            return new int[]{s};
        }

        int[] answer = new int[n];

        int count = n;
        for (int i = 0; i < n; i++) {
            answer[i] = s / count;
            s -= answer[i];
            count--;
        }
        return answer;
    }

}