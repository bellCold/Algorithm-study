import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[51][51][51];
        dp[0][0][0] = 1;
        dp[20][20][20] = 1048576;

        StringTokenizer st;
        while (true) {
            String s = br.readLine();
            if (s.equals("-1 -1 -1")) {
                break;
            }
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

            int ret = w(a, b, c);

            sb.append(ret).append("\n");
        }

        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[0][0][0];
        } else if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20];
        } else if(dp[a][b][c] != 0) {
            return dp[a][b][c];
        } else if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return dp[a][b][c];
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            return dp[a][b][c];
        }
    }
}
