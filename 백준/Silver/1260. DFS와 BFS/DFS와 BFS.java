
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int[] answerDFS;
    static int[] answerBFS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        node = new ArrayList[N + 1];
        answerDFS = new int[N];
        answerBFS = new int[N];

        for (int i = 1; i < N + 1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(node[i]);
        }

        visited = new boolean[N + 1];
        dfs(start);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(start);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.print(currNode + " ");
            for (int i : node[currNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : node[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
