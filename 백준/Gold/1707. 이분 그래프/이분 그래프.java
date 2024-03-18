import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] graph;
    static int[] checksum;
    static boolean[] visited;
    static boolean isBinaryGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);

            graph = new List[node + 1];
            for (int j = 1; j < node + 1; j++) {
                graph[j] = new ArrayList<>();
            }
            visited = new boolean[node + 1];
            checksum = new int[node + 1];
            isBinaryGraph = true;

            for (int j = 0; j < edge; j++) {
                String[] edgeInput = br.readLine().split(" ");
                int start = Integer.parseInt(edgeInput[0]);
                int end = Integer.parseInt(edgeInput[1]);
                graph[start].add(end);
                graph[end].add(start);
            }

            for (int j = 1; j < node + 1; j++) {
                if (isBinaryGraph) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if (isBinaryGraph) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int i : graph[start]) {
            if (!visited[i]) {
                checksum[i] = (checksum[start] + 1) % 2;
                dfs(i);
            } else if (checksum[i] == checksum[start]) {
                isBinaryGraph = false;
                return;
            }
        }
    }

}
