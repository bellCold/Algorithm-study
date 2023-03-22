import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        map = new int[col][row];
        visited = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            String[] order = br.readLine().split("");
            for (int j = 0; j < order.length; j++) {
                map[i][j] = Integer.parseInt(order[j]);
            }
        }

        bfs(0, 0);

        System.out.println(map[col - 1][row - 1]);
    }

    private static void bfs(int col, int row) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col, row});
        visited[col][row] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                if (x >= 0 && y >= 0 && x < visited.length && y < visited[0].length && !visited[x][y] && map[x][y] == 1) {
                    visited[x][y] = true;
                    map[x][y] = map[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}