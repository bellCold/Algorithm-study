import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] chessMap;
    static int answer = 32;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chessMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char order : br.readLine().toCharArray()) {
                chessMap[i][j] = order == 'W';
                j++;
            }
        }

        int maxXCoordinate = N - 7;
        int maxYCoordinate = M - 7;

        for (int i = 0; i < maxXCoordinate; i++) {
            for (int j = 0; j < maxYCoordinate; j++) {
                findMinCount(i, j);
            }
        }

        System.out.println(answer);
    }

    /**
     * W -> true
     * B -> false
     */
    private static void findMinCount(int x, int y) {
        int count = 0;
        boolean flag = chessMap[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (chessMap[i][j] != flag) {
                    count++;
                }
                flag = !flag;
            }
            flag = !flag;
        }

        count = Math.min(count, 64 - count);

        answer = Math.min(answer, count);
    }
}