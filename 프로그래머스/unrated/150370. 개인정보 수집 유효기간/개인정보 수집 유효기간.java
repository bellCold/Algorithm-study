import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate = LocalDate.parse(today, dateTimeFormatter);

        Map<String, Integer> termList = new HashMap<>();

        // 약관 셋팅
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termList.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate privacyDate = LocalDate.parse(privacy[0], dateTimeFormatter).plusMonths(termList.get(privacy[1])).minusDays(1);

            if (privacyDate.isBefore(localDate)) {
                ans.add(i + 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}