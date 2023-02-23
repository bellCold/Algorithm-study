import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int k) {
        Queue<Integer> list = new LinkedList<>();

        for (int number : numbers) {
            list.add(number);
        }

        int count = 1;
        while (count != k) {
            list.add(list.poll());
            list.add(list.poll());
            count++;
        }

        return list.peek();
    }

}