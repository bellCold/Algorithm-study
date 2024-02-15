import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.add((long) work);
        }


        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                if (pq.peek() == 1) {
                    pq.poll();
                } else {
                    long currentMaxWork = pq.poll();
                    currentMaxWork--;
                    pq.add(currentMaxWork);
                }
            }
        }

        long sum = 0;

        while (!pq.isEmpty()) {
            sum += Math.pow(pq.poll(), 2);
        }
        
        return sum;
    }

}