import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] intArray = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            intArray[i] = Integer.parseInt(br.readLine());
            if (max < intArray[i]) {
                max = intArray[i];
            }
        }
        max++;
        long maxLength = findMaxLengthOfLAN(intArray, N, max);

        System.out.println(maxLength);
    }

    private static long findMaxLengthOfLAN(int[] intArray, int N, long max) {
        long low = 0;
        long mid = 0;

        while (low < max) {
            long count = 0;
            mid = (low + max) / 2;
            for (long number : intArray) {
                count += number / mid;
            }
            if (count < N) {
                max = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }

}