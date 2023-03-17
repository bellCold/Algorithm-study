class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for (char c : s.toCharArray()) {
            int targetCode = c;
            if (targetCode != 32) {
                if (targetCode + n > 122) {
                    answer += String.valueOf((char) (targetCode + n - 26));
                } else if (targetCode + n <= 122 && targetCode >= 97) {
                    answer += String.valueOf((char) (targetCode + n));
                } else if (targetCode >= 65 && targetCode + n <= 90) {
                    answer += String.valueOf((char) (targetCode + n));
                } else {
                    answer += String.valueOf((char) (targetCode + n - 26));
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}