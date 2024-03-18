import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] sender = new int[]{0, 0, 1, 1, 2, 2};
    static int[] receiver = new int[]{1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        now = new int[3];
        String[] split = br.readLine().split(" ");
        now[0] = Integer.parseInt(split[0]);
        now[1] = Integer.parseInt(split[1]);
        now[2] = Integer.parseInt(split[2]);
        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[now[0]][now[1]] = true;
        answer[now[2]] = true;
        while (!queue.isEmpty()) {
            AB poll = queue.poll();
            int a = poll.a;
            int b = poll.b;
            int c = now[2] - a - b;
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }

            }

        }
    }

    static class AB {
        int a;
        int b;

        public AB(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
