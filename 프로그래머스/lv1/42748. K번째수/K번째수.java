import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            List<Integer> filter = new ArrayList<>();
            for (int j = a - 1; j <= b - 1; j++) {
                filter.add(array[j]);
            }
            Collections.sort(filter);
            ans.add(filter.get(c - 1));

        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}