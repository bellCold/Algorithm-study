import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    static class Mark {
        int x;
        int y;

        public Mark(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Mark> queue = new LinkedList<>();

        int temp = 0;
        for (int priority : priorities) {
            pq.add(priority);
            queue.add(new Mark(priority, temp));
            temp++;
        }

        int count = 1;
        while (true) {
            while (!pq.isEmpty() && !queue.isEmpty() && queue.peek().x != pq.peek()) {
                queue.add(queue.poll());
            }
            if (queue.peek().y != location) {
                pq.poll();
                queue.poll();
                count++;
            } else {
                break;
            }
        }
        return count;

    }
}