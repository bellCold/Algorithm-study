import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());

        String[] split = br.readLine().split("");
        pq.addAll(Arrays.asList(split));

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            ans.append(pq.poll());
        }

        System.out.println(ans);
    }
}


