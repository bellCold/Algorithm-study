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
    static int safeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String[] mapList = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(mapList[j]);
            }
        }

        buildWallAndSearchSafeZone();

        System.out.println(safeZone);
    }

    private static void buildWallAndSearchSafeZone() {
        dfs(0);
    }

    private static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copyMap[i][j] = map[i][j];

                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + curr[0];
                int y = dy[i] + curr[1];
                if (x >= 0 && y >= 0 && x < map.length && y < map[0].length && copyMap[x][y] == 0) {
                    copyMap[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
        }

        countSafeZone(copyMap);
    }

    private static void countSafeZone(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[0].length; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        safeZone = Math.max(safeZone, count);
    }


}
