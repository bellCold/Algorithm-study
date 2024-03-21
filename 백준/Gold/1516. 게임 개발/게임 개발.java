import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        int[] selfBuild = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int order = Integer.parseInt(st.nextToken());
                if (order == -1) {
                    break;
                }
                A.get(order).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : A.get(now)) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
                System.out.println(result[i] + selfBuild[i]);
        }

    }

}

