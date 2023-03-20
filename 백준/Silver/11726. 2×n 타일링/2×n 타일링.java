import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        if (number <= 2) {
            System.out.println(number);
            return;
        }

        int[] dp = new int[number + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= number; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[number]);
    }
}