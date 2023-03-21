import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] scoreRepository = new int[k - 1];
//        int[] solution1 = solution.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]); // 10

            int count = 0;
            for (int j = 0; j < k - 1; j++) {
                if (!pq.isEmpty()) {
                    scoreRepository[j] = pq.poll();
                    count = j;
                }
            }

            int temp = -1;
            if (!pq.isEmpty()) {
                answer.add(pq.peek());
            } else {
                for (int c = 0; c < count + 1; c++) {
                    temp = scoreRepository[c];
                }
                answer.add(temp);
            }

            for (int c = 0 ; c <  count + 1; c++) {
                pq.add(scoreRepository[c]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
}