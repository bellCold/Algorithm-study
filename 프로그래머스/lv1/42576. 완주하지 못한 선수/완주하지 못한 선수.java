import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> list = new HashMap<>();
        for (String s : participant) {
            list.put(s, list.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            list.put(s, list.getOrDefault(s, 0) - 1);
        }
        
        String answer = "";
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (entry.getValue() == 1) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}