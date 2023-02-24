import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> key = new HashMap<>();

        for (String s : keymap) {
            String[] split = s.split("");
            for (int i = 0; i < split.length; i++) {
                if (key.containsKey(split[i])) {
                    if (key.get(split[i]) > i + 1) {
                        key.put(split[i], i + 1);
                    }
                } else {
                    key.put(split[i], i + 1);
                }
            }
        }

        int[] ans = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String target = targets[i];
            String[] split = target.split("");
            boolean flag = true;
            for (int j = 0; j < split.length; j++) {
                if (key.containsKey(split[j])) {
                    count += key.get(split[j]);
                } else {
                    flag = false;
                }
            }
            if (flag) {
                ans[i] = count;
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}