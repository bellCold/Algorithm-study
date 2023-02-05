import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 9

        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 1 2 3 5 7 9 10 11 12
        Arrays.sort(array);

        // 13
        int target = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int sum = array[start] + array[end];
            if (target == sum) {
                cnt++;
                end--;
            } else if (target < sum) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}
