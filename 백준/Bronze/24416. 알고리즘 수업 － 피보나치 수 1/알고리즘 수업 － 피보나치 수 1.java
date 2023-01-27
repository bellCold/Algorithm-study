import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dpArray = new int[50];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n) + " " + count / 2);
    }

    private static int fibo(int n) {
        count++;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            if (dpArray[n] > 0) {
                return dpArray[n];
            }
            dpArray[n] = fibo(n - 1) + fibo(n - 2);
            return dpArray[n];
        }
    }
}