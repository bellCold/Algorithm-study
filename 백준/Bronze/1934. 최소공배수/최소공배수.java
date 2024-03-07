import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] orderSplit = br.readLine().split(" ");
            int first = Integer.parseInt(orderSplit[0]);
            int second = Integer.parseInt(orderSplit[1]);

            int result = getMinimumMultiple(first, second);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int getMinimumMultiple(int first, int second) {
        int min = Math.min(first, second);
        int multiply = Math.multiplyExact(first, second);
        while (true) {
            if (first % min == 0 && second % min == 0) {
                return multiply / min;
            }
            min--;
        }
    }
}
