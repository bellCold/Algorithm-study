import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ", -1);
        List<String> answer = new ArrayList<>();
        for (String word : split) {
            String[] wordSplit = word.split("");
            for (int i = 0; i < wordSplit.length; i++) {
                if (i % 2 == 0) {
                    wordSplit[i] = wordSplit[i].toUpperCase(Locale.ROOT);
                } else {
                    wordSplit[i] = wordSplit[i].toLowerCase(Locale.ROOT);
                }
            }
            answer.add(Arrays.stream(wordSplit).collect(Collectors.joining()));
        }
        return answer.stream().collect(Collectors.joining(" "));
    }
}