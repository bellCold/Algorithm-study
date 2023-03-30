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
    static int day = 0;

    static class Tomato {
        private int x;
        private int y;
        private int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (split[j].equals("1")) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }

        bfs(queue);

        System.out.println(checkMap(map) ? day : -1);
    }

    private static boolean checkMap(int[][] map) {
        boolean flag = true;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static void bfs(Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            Tomato currTomato = queue.poll();
            day = currTomato.day;
            for (int i = 0; i < 4; i++) {
                int x = currTomato.x + dx[i];
                int y = currTomato.y + dy[i];
                if (x >= 0 && y >= 0 && x < map.length && y < map[0].length && !visited[x][y] && map[x][y] == 0) {
                    map[x][y] = 1;
                    visited[x][y] = true;
                    queue.add(new Tomato(x, y, currTomato.day + 1));
                }
            }
        }
    }
}