import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int query = Integer.parseInt(br.readLine());
        String[] ans = new String[query];

        for (int i = 0; i < query; i++) {
            String question = br.readLine();
            int c = 0;
            for (char q : question.toCharArray()) {
                c += q == '(' ? 1 : -1;
                if (c == -1) {
                    ans[i] = "NO";
                    break;
                }
            }
            ans[i] = c == 0 ? "YES" : "NO";
        }

        Arrays.stream(ans).forEach(System.out::println);
    }
}