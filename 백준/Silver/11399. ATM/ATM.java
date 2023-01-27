import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[] dp = new int[n];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(array);
        if (n == 1) {
            System.out.println(array[0]);
            return;
        }

        dp[0] = array[0];
        dp[1] = array[1] + array[0];

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + array[i];
        }

        System.out.println(Arrays.stream(dp).reduce(Integer::sum).getAsInt());
    }

}