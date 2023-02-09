import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> timer = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = timer.pop() + 1;
                stack.pop();
            }
            stack.push(i);
            timer.push(-1);
            for (int j = 0; j < timer.size(); j++) {
                timer.set(j, timer.get(j) + 1);
            }
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = timer.pop();
        }
        return answer;
    }
}