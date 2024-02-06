import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] checksum = new boolean[N];

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int stopCount = 0;
        int fixIndex = 0;
        while (stopCount != N) {
            int moveCount = 0;
            while (true) {
                if (!checksum[fixIndex]) {
                    moveCount++;
                }
                if (moveCount == K && !checksum[fixIndex]) {
                    checksum[fixIndex] = true;
                    sb.append(fixIndex + 1);
                    break;
                }
                fixIndex++;
                if (fixIndex == N) {
                    fixIndex = 0;
                }
            }
            stopCount++;
            if (stopCount != N) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
