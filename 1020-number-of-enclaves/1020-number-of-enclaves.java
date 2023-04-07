import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public int numEnclaves(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        int zone = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(i, j, grid);
                    zone += findSafeZone(grid);
                }
            }
        }
        return zone;
    }

    private int findSafeZone(int[][] grid) {
        boolean flag = true;
        int safeCount = queue.size();
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (position[0] == 0 || position[0] == grid.length - 1 || position[1] == 0 || position[1] == grid[0].length - 1) {
                flag = false;
                queue.clear();
            }
        }
        
        return !flag ? 0 : safeCount;
    }

    private void dfs(int col, int row, int[][] grid) {
        if (col < 0 || row < 0 || col == grid.length || row == grid[0].length || visited[col][row] || grid[col][row] == 0) {
            return;
        }

        visited[col][row] = true;
        queue.add(new int[]{col, row});

        for (int i = 0; i < 4; i++) {
            dfs(col + dx[i], row + dy[i], grid);
        }
    }
}