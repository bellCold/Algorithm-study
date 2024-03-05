import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] primeNumber = new int[10000001];
        for (int i = 2; i < primeNumber.length; i++) {
            primeNumber[i] = i;
        }

        for (int i = 2; i < primeNumber.length; i++) {
            if (primeNumber[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= 10000000; j = i + j) {
                primeNumber[j] = 0;
            }
        }

        for (int i = N; i < 10000001; i++) {
            if (primeNumber[i] != 0) {
                String first = String.valueOf(i);
                StringBuilder reverse = new StringBuilder(first).reverse();
                if (first.contentEquals(reverse)) {
                    System.out.println(first);
                    return;
                }
            }
        }
    }
}
