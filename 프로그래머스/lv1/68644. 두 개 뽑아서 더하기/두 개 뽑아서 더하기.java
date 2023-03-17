import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[j] + numbers[i]);
            }
        }
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}