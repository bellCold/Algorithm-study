import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> ATeam = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> BTeam = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : A) {
            ATeam.add(i);
        }

        for (int i : B) {
            BTeam.add(i);
        }

        int score = 0;
        while (!ATeam.isEmpty() && !BTeam.isEmpty()) {
            if (!ATeam.isEmpty() && !BTeam.isEmpty() && (BTeam.peek() > ATeam.peek())) {
                ATeam.poll();
                BTeam.poll();
                score++;
            } else if (!ATeam.isEmpty() && !BTeam.isEmpty() && (BTeam.peek() <= ATeam.peek())) {
                ATeam.poll();
            }
        }
        return score;
    }
}