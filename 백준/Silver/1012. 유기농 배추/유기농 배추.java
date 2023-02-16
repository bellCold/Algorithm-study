import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] ans;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int query = Integer.parseInt(br.readLine());
        ans = new int[query];

        StringTokenizer st;

        for (int i = 0; i < query; i++) {
            // 가로 세로 배추개수
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int baechu = Integer.parseInt(st.nextToken());

            map = new int[x][y];
            visited = new boolean[x][y];
            // 배추 셋팅
            for (int j = 0; j < baechu; j++) {
                st = new StringTokenizer(br.readLine());
                int baechuX = Integer.parseInt(st.nextToken());
                int baechuY = Integer.parseInt(st.nextToken());
                map[baechuX][baechuY] = 1;
            }

            int cnt = 0;

            for (int a = 0; a < map.length; a++) {
                for (int b = 0; b < map[0].length; b++) {
                    if (!visited[a][b] && map[a][b] == 1) {
                        cnt++;
                        dfs(a, b);
                    }
                }
            }
            ans[i] = cnt;
        }
        Arrays.stream(ans).forEach(System.out::println);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x == map.length || y == map[0].length || map[x][y] == 0) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }

}