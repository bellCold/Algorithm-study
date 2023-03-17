import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining()).equals("") ? 1 : 0;

    }
}