import java.util.*;

class Solution {
    static class Mark {
        int x;
        int y;

        public Mark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Mark> marks = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            marks.add(new Mark(priorities[i], i));
            pq.add(priorities[i]);
        }

        int cnt = 1;
        while (true) {
            while (pq.peek() != marks.peek().getX()) {
                marks.add(marks.poll());
            }
            if (marks.peek().getY() == location) {
                break;
            }
            marks.poll();
            pq.poll();
            cnt++;
        }
        return cnt;
    }
}