import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        while (true) {
            long count1 = 0;
            for (char c : Integer.toBinaryString(answer).toCharArray()) {
                if (c == '1') {
                    count1++;
                }
            }
            if (count == count1 && n < answer) {
                break;
            }
            answer++;
        }
        return answer;
    }
}