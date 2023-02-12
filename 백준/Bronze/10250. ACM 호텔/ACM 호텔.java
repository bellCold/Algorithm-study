import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int query = Integer.parseInt(br.readLine());
        int[] answer = new int[query];

        StringTokenizer st;
        int x = 0;
        int y = 0;
        for (int i = 0; i < query; i++) {
            st = new StringTokenizer(br.readLine());
            // 층 옆 방문순
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            x = n / h + 1;
            y = n % h;

            if (y == 0) {
                x = n / h;
                y = h;
            }
            answer[i] = y * 100 + x;
        }
        Arrays.stream(answer).forEach(System.out::println);
    }

}
