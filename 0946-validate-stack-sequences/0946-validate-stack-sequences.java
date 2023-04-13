import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushList = new Stack<>();
        Stack<Integer> popList = new Stack<>();

        int count = 0;
        int pushCount = 0;
        while (pushCount < pushed.length) {
            pushList.push(pushed[pushCount]);
            pushCount++;
            while (!pushList.isEmpty() && count < popped.length && pushList.peek() == popped[count]) {
                popList.push(pushList.pop());
                count++;
            }
        }

        boolean answer = true;
        if (popList.size() == popped.length) {
            count = popped.length - 1;
            while (!popList.isEmpty()) {
                if (popList.pop() != popped[count]) {
                    answer = false;
                }
                count--;
            }
            return answer;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println(b);
    }
}