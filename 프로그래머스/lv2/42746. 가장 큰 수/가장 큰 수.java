import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(Collections.reverseOrder((o1, o2) -> o1.concat(o2).compareTo(o2.concat(o1))))
                .collect(Collectors.joining());

        return answer.startsWith("00") ? "0" : answer;
    }
}