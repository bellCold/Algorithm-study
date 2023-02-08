import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (stack.peek() != i){
                stack.push(i);
            }
        }
        return stack.stream().mapToInt(value -> value).toArray();
    }
}