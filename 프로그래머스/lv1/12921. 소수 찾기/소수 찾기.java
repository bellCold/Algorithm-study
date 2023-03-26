class Solution {
    public int solution(int n) {
        int[] ari = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            ari[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                if (j != i ) {
                    ari[j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (ari[i] != 0) {
                answer++;
            }
        }
        return answer;
    }
    
}
