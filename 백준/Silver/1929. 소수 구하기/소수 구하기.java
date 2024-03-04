import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] primeNumber = new int[1000001];
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        primeNumber[1] = 1;

        for (int i = 2; i < primeNumber.length; i++) {
            int count = 2;
            while (i * count < primeNumber.length) {
                if (primeNumber[i * count] == 0) {
                    primeNumber[i * count] = i * count;
                }
                count++;
            }
        }

        for (int i = start; i <= end; i++) {
            if (primeNumber[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
