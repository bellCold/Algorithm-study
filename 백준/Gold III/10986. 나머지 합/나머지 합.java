import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] dp = new long[n + 1];
        long[] count = new long[m];

        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + Long.parseLong(st.nextToken());
            if (dp[i] % m == 0) {
                ans++;
            }
            count[(int) (dp[i] % m)]++;
        }
        
        for (int i = 0; i < m; i++) {
            if (count[i] > 1) {
                ans += count[i] * (count[i] - 1) / 2;
            }
        }
        System.out.println(ans);
    }

}
