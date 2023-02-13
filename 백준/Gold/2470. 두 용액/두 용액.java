import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // -99 -2 -1 4 98
        List<Integer> ans = new ArrayList<>();
        ans.add(1000000000);
        ans.add(1000000000);
        int sum = 0;
        int min = 0;
        int start = 0;
        int end = array.length - 1;
        while (start != end) {
            sum = array[start] + array[end];
            int ansSum = ans.get(0) + ans.get(1);
            if (Math.abs(sum) < Math.abs(ansSum)) {
                ans.clear();
                ans.add(array[start]);
                ans.add(array[end]);
            }
            if (sum == 0) {
                ans.clear();
                ans.add(array[start]);
                ans.add(array[end]);
                break;
            } else if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            }
        }
        ans.stream().sorted().forEach(value -> System.out.print(value + " "));
    }

}


