import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> foods = new PriorityQueue<>();

        for (int food : scoville) {
            foods.add(food);
        }

        int answer = 0;
        while (foods.size() >= 2 && foods.peek() < K) {
            foods.add(foods.poll() + (foods.poll() * 2));
            answer++;
            if (foods.size() < 2 && foods.peek() < K) {
                return -1;
            }
        }
        return answer;
    }
}