class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (char c : s.toCharArray()) {
            char charTemp = c;
            int count = 0;
            while (count != index) {
                charTemp++;
                if (charTemp > 122) {
                    charTemp -= 26;
                }
                if (!skip.contains(String.valueOf(charTemp))) {
                    count++;
                }
            }
            answer += String.valueOf(charTemp);
        }
        return answer;
    }
}
