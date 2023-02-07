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
        int arrayCnt = 0;
        int day = 1;

        while (!queue.isEmpty()) {
            int ansCnt = 0;
            while (!queue.isEmpty() && queue.peek() + (speeds[arrayCnt] * day) >= 100) {
                queue.poll();
                arrayCnt++;
                ansCnt++;
            }
            day++;
            if (ansCnt != 0) {
                ans.add(ansCnt);
            }
        }

        return ans.stream().mapToInt(value -> value).toArray();
    }
}