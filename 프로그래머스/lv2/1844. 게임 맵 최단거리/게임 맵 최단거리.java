import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(0, 0, maps);
        int answer = maps[maps.length - 1][maps[0].length - 1];
        return answer == 1 ? -1 : answer;
    }

    private void bfs(int col, int row, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col, row});
        visited[col][row] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length) {
                    if (!visited[x][y] && maps[x][y] != 0) {
                        visited[x][y] = true;
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}