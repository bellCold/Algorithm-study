import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> list = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            list.put(clothes[i][1], list.getOrDefault(clothes[i][1], 0) + 1);
        }
        Collection<Integer> values = list.values();
        return values.stream().reduce(1, (a, b) -> a * (b + 1)) - 1;
    }

  
}