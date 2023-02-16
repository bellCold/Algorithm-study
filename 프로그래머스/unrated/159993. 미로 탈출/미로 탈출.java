import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static int[][] map;
    static boolean[][] visited;
    static int startX = 0;
    static int startY = 0;
    static int leverX = 0;
    static int leverY = 0;
    static int exitX = 0;
    static int exitY = 0;

    public int solution(String[] maps) {
        map = new int[maps.length + 1][maps[0].length() + 1];
        visited = new boolean[maps.length + 1][maps[0].length() + 1];


        // "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"
        initMap(maps);
        // 시작 지점부터 레버까지 탐색
        bfs(startX, startY);

        int currLength = map[leverX][leverY];
        // -1 이 되는 경우는 두가지 시작지점에서 레버까지 갈 수 없거나 or 레버에서 출구까지 갈 수 없거나
        if (currLength == 0) {
            return -1;
        }
        // todo 레버에서 출구까지 거리 재기
        initMap(maps);
        visited = new boolean[maps.length + 1][maps[0].length() + 1];
        bfs(leverX, leverY);

        if (map[exitX][exitY] == 0) {
            return -1;
        } else {
         return currLength + map[exitX][exitY];
        }
    }

    private void initMap(String[] maps) {
        for (int i = 1; i <= maps.length; i++) {
            String[] split = maps[i - 1].split("");
            for (int j = 1; j <= split.length; j++) {
                if (split[j - 1].equals("S")) {
                    startX = i;
                    startY = j;
                } else if (split[j - 1].equals("L")) {
                    leverX = i;
                    leverY = j;
                } else if (split[j - 1].equals("E")) {
                    exitX = i;
                    exitY = j;
                }
                if (split[j - 1].equals("S") || split[j - 1].equals("L") || split[j - 1].equals("E") || split[j - 1].equals("O")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }
    }

    private void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + curr[0];
                int y = dy[i] + curr[1];
                if (x > 0 && y > 0 && x < map.length && y < map[0].length && !visited[x][y] && map[x][y] == 0) {
                    visited[x][y] = true;
                    map[x][y] = map[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}