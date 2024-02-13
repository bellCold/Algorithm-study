import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int[] problem;
    static List<Integer> answer;
    static List<Integer>[] problemEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int problemCount = Integer.parseInt(firstLine[0]);
        int infoCount = Integer.parseInt(firstLine[1]);

        // data init
        answer = new ArrayList<>();
        problem = new int[problemCount + 1];
        problemEdge = new ArrayList[problemCount + 1];
        for (int i = 1; i <= problemCount; i++) {
            problemEdge[i] = new ArrayList<>();
        }

        for (int i = 0; i < infoCount; i++) {
            String[] order = br.readLine().split(" ");
            int firstProblem = Integer.parseInt(order[0]);
            int secondProblem = Integer.parseInt(order[1]);
            problemEdge[firstProblem].add(secondProblem);
            problem[secondProblem]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= problemCount; i++) {
            if (problem[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            System.out.print(now + " ");
            for (int next : problemEdge[now]) {
                problem[next]--;
                if (problem[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }


}
