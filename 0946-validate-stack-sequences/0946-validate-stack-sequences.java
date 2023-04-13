import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushList = new Stack<>();

        int count = 0;
        for (int i : pushed) {
            pushList.push(i);
            while (!pushList.isEmpty() && count < popped.length && pushList.peek() == popped[count]) {
                pushList.pop();
                count++;
            }
        }

        return count == popped.length;
    }
}