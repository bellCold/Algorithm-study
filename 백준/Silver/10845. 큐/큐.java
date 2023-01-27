import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String order = br.readLine();
            if (order.contains(" ")) {
                String[] split = order.split(" ");
                deque.add(split[1]);
            } else if (order.equals("pop")) {
                if (deque.isEmpty()) {
                    answer.append(-1).append("\n");
                } else {
                    answer.append(deque.poll()).append("\n");
                }
            } else if (order.equals("size")) {
                answer.append(deque.size()).append("\n");
            } else if (order.equals("empty")) {
                if (deque.isEmpty()) {
                    answer.append(1).append("\n");
                } else {
                    answer.append(0).append("\n");
                }
            } else if (order.equals("front")) {
                if (deque.isEmpty()) {
                    answer.append(-1).append("\n");
                } else {
                    answer.append(deque.peekFirst()).append("\n");
                }

            } else if (order.equals("back")) {
                if (deque.isEmpty()) {
                    answer.append(-1).append("\n");
                } else {
                    answer.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(answer);
    }

}