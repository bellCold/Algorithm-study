import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> top = new PriorityQueue<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");

            if (split[0].equals("I")) {
                top.add(Integer.parseInt(split[1]));
            } else {
                if (!top.isEmpty()) {
                    if (split[1].equals("1")) {
                        int size = top.size();
                        List<Integer> temp = new ArrayList<>();
                        for (int j = 0; j < size - 1; j++) {
                            temp.add(top.poll());
                        }
                        top.poll();
                        top.addAll(temp);
                    } else {
                        top.poll();
                    }
                }
            }
        }
        if (top.size() == 1) {
            return new int[]{top.peek(), top.peek()};
        }
        if (top.isEmpty()) {
            return new int[]{0, 0};
        }
        int min = top.poll();
        int max = 0;
        while (!top.isEmpty()) {
            max = top.poll();
        }

        return new int[]{max, min};
    }
}