import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 2) {
            System.out.println(N);
            return;
        }

        int ans = 0;
        int a = 2;
        int b = 1;
        for (int i = 3; i <= N; i++) {
            ans = (a + b) % 15746;
            b = a;
            a = ans;
        }

        System.out.println(ans);
    }


}