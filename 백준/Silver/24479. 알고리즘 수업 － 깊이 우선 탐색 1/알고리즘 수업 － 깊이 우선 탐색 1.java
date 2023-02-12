import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int[] answer;
    static int count = 1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        node = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(node[i]);
        }

        dfs(v);
        for (int i = 1; i < n + 1; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        answer[v] = count++;
        for (int i : node[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}