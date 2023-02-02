import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        long a = 1;
        long b = 1;

        long ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        if (n == 0) {
            System.out.println(0);
        } else if (n <= 2) {
            System.out.println(1);
        } else {
            System.out.println(ans);
        }
    }
}
