import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int count = fibo(k, n);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static int fibo(int k, int n) {
        if (n == 0)
            return 0;
        else if (k == 0)
            return n;
        else {
            return fibo(k, n - 1) + fibo(k - 1, n);
        }
    }
}