import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> card1Q = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> card2Q = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalQ = new LinkedList<>(Arrays.asList(goal));

        while (!goalQ.isEmpty()) {
            String target = goalQ.poll();
            if (!card1Q.isEmpty() && card1Q.peek().equals(target)) {
                card1Q.poll();
            } else if (!card2Q.isEmpty() && card2Q.peek().equals(target)) {
                card2Q.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}