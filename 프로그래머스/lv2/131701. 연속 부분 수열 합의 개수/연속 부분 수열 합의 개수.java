import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> ans = new HashSet<>();

        int[] array = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
            array[i + elements.length] = elements[i];
        }

        int windowSize = 1;
        while (windowSize <= elements.length) {
            int temp = 0;
            while (temp != elements.length) {
                int sum = 0;
                for (int i = temp; i < temp + windowSize; i++) {
                    sum += array[i];
                }
                ans.add(sum);
                temp++;
            }
            windowSize++;
        }

        return ans.size();
    }
    
}