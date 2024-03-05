import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long start = Long.parseLong(split[0]);
        long end = Long.parseLong(split[1]);

        long[] primeNumber = new long[10000001];

        for (int i = 2; i < primeNumber.length; i++) {
            primeNumber[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(primeNumber.length); i++) {
            if (primeNumber[i] == 0) {
                continue;
            }
            for (int j = i + i; j < primeNumber.length; j = j + i) {
                primeNumber[j] = 0;
            }
        }


        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (primeNumber[i] != 0) {
                long temp = primeNumber[i];
                while ((double) primeNumber[i] <= (double) end / (double) temp) {
                    if ((double) primeNumber[i] >= (double) start / (double) temp) {
                        count++;
                    }
                    temp *= primeNumber[i];
                }
            }
        }
        System.out.println(count);
    }
}
