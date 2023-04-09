import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scoreList = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            scoreList.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            for (int j = 0; j < photo[i].length; j++) {
                totalScore += scoreList.getOrDefault(photo[i][j], 0);
            }
            answer[i] = totalScore;
        }

        return answer;
    }
}