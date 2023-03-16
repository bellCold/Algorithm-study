import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }

        List<Integer> ans = new ArrayList<>();

        int curDay = 1;
        int arrayCount = 0;

        while (!queue.isEmpty()) {

            int completionCount = 0;
            while (!queue.isEmpty() && speeds[arrayCount] * curDay + queue.peek() >= 100) {
                queue.poll();
                completionCount++;
                arrayCount++;
            }

            if (completionCount != 0) {
                ans.add(completionCount);
            }
            curDay++;
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray(); 
    }
}