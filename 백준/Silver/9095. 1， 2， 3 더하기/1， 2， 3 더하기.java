import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[] ans = new int[testCase];
        int max = 0;
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            ans[i] = number;
            if (max < number) {
                max = number;
            }
        }

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(dp[an]).append("\n");
        }
        
        System.out.println(sb);
    }
}


