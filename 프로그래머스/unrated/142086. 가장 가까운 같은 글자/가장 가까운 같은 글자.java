class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] split = s.split("");
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (temp.lastIndexOf(split[i]) == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - temp.lastIndexOf(split[i]);
            }
            temp += split[i];
        }
        return answer;
    }
}
