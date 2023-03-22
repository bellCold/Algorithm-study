import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] node;
    static boolean[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        node = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);
            node[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(node[i]);
        }

        int[] ans = new int[N + 1];

        dfs(node, R, ans);

        for (int i = 1; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void dfs(List<Integer>[] node, int start, int[] ans) {
        if (visited[start]) {
            return;
        }

        /**
         * 1 4
         * 1 2
         * 2 3
         * 2 4
         * 3 4
         */

        /**
         * ans[1] = 1
         * ans[2] = 2;
         * ans[3] = 4;
         *
         */
        ans[start] = count++;

        visited[start] = true;

        for (int num : node[start]) {
            if (!visited[num]) {
                dfs(node, num, ans);
            }
        }
    }

}