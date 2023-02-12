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
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];
        answer = new int[row + 1][col + 1];

        for (int i = 1; i < row + 1; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j < col + 1; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        bfs(1, 1, map);
        System.out.println(answer[row][col]);
    }

    private static void bfs(int row, int col, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new int[]{row, col});
        answer[row][col] = map[row][col];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        visited[x][y] = true;
                        map[x][y] = map[now[0]][now[1]] + 1;
                        answer[x][y] = map[x][y];
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
