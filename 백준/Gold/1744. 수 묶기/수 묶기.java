import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positivePQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativePQ = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                positivePQ.add(input);
            } else {
                negativePQ.add(input);
            }
        }

        int result = 0;
        while (positivePQ.size() != 1 && !positivePQ.isEmpty()) {
            int first = positivePQ.poll();
            int second = positivePQ.poll();

            if (first == 1 || second == 1) {
                result += first + second;
            } else {
                result += first * second;
            }
        }

        if (!positivePQ.isEmpty()) {
            result += positivePQ.poll();
        }

        while (negativePQ.size() != 1 && !negativePQ.isEmpty()) {
            int first = negativePQ.poll();
            int second = negativePQ.poll();

            result += first * second;
        }

        if (!negativePQ.isEmpty()) {
            result += negativePQ.poll();
        }

        System.out.println(result);

    }


}
