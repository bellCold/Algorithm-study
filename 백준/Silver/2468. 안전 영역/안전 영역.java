import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int maxSafeZone = Integer.MIN_VALUE;
    static int maxRain = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] maps = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(maps[j]);
                maxRain = Math.max(maxRain, Integer.parseInt(maps[j]));
            }
        }

        for (int k = 0; k <= maxRain; k++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            maxSafeZone = Math.max(maxSafeZone, count);
        }
        System.out.println(maxSafeZone);
    }

    private static void dfs(int i, int j, int rainMount) {
        if (i < 0 || j < 0 || i == map.length || j == map.length || visited[i][j] || map[i][j] <= rainMount) {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, rainMount);
        dfs(i - 1, j, rainMount);
        dfs(i, j + 1, rainMount);
        dfs(i, j - 1, rainMount);
    }

}