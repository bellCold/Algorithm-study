import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(array);

        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = array.length - 1;
        int first = 0;
        int second = 0;
        while (start != end) {
            int sum = array[start] + array[end];
            if (Math.abs(sum) < ans) {
                ans = Math.abs(sum);
                first = array[start];
                second = array[end];
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(first + " " + second);
    }

}


