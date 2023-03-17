class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        while (count != n) {
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
            answer++;
            count++;
        }
        return answer - 1;
    }
}