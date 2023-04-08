import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> list = new HashMap<>();
        Map<Integer, String> grade = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            list.put(players[i], i);
            grade.put(i, players[i]);
        }

        for (String calling : callings) {
            int currRank = list.get(calling);
            list.put(calling, list.get(calling) - 1);

            String swapName = grade.get(currRank - 1);
            int swapRank = list.get(swapName);
            list.put(swapName, swapRank + 1);
            grade.put(currRank - 1, calling);
            grade.put(swapRank + 1, swapName);
        }

        return list.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toArray(String[]::new);
    }
}