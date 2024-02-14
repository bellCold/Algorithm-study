import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] dp = new int[N + 1][N + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = i;
                } else if (j == 0 || i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[N][K]);
    }
}


