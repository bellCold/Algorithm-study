import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        TreeSet<Integer> ans = new TreeSet<>();

        int count = 1;
        while (count != number) {
            int temp = 0;
            String[] split = String.valueOf(count).split("");
            for (String s : split) {
                temp += Integer.parseInt(s);
            }

            if (count + temp == number) {
                ans.add(count);
            }
            count++;
        }

        System.out.println(ans.isEmpty() ? 0 : ans.first());
    }
}