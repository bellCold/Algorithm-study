import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    static class Mark {
        private int insertNumber;
        private int targetNumber;

        public int minus() {
            return Math.abs(this.insertNumber - this.targetNumber);
        }

        public Mark(int insertNumber, int targetNumber) {
            this.insertNumber = insertNumber;
            this.targetNumber = targetNumber;
        }

        public int getInsertNumber() {
            return insertNumber;
        }
    }

    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];

        PriorityQueue<Mark> filter = new PriorityQueue<>(Comparator.comparing(Mark::minus).thenComparing(Collections.reverseOrder(Comparator.comparing(Mark::getInsertNumber))));

        for (int number : numlist) {
            filter.add(new Mark(number, n));
        }

        int i = 0;
        while (!filter.isEmpty()) {
            answer[i] = filter.poll().getInsertNumber();
            i++;
        }

        return answer;
    }
}