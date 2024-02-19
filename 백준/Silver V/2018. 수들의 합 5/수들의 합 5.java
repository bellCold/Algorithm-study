import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (end != N) {
            if (sum == N) {
                count++;
                end++;
                sum = sum + end;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            } else if (sum < N) {
                end++;
                sum = sum + end;
            }
        }
        System.out.println(count);
    }
}
