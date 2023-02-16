import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] map;
    static String[][] sackMap;
    static boolean[][] visited;
    static int[] ans;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        sackMap = new String[n][n];
        visited = new boolean[n][n];
        ans = new int[2];

        // map setting
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = split[j];
                if (split[j].equals("G")) {
                    sackMap[i][j] = "R";
                } else {
                    sackMap[i][j] = split[j];
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    dfs(i, j, map[i][j], map);
                }
            }
        }
        ans[0] = cnt;

        cnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    dfs(i, j, sackMap[i][j], sackMap);
                }
            }
        }
        ans[1] = cnt;

        System.out.print(ans[0] + " " + ans[1]);
    }

    private static void dfs(int x, int y, String target, String[][] map) {
        if (x < 0 || y < 0 || x == map.length || y == map.length || visited[x][y] || !map[x][y].equals(target)) {
            return;
        }

        visited[x][y] = true;
        dfs(x - 1, y, target, map);
        dfs(x + 1, y, target, map);
        dfs(x, y - 1, target, map);
        dfs(x, y + 1, target, map);
    }

}


