import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> curr = new HashSet<>();
        HashSet<Integer> next;

        curr.add(n);
        int cnt = 0;
        while (!curr.isEmpty()) {
            if (curr.contains(1)) {
                break;
            }
            next = new HashSet<>();
            for (int number : curr) {
                int a = number - 1;
                int b = 0;
                int c = 0;
                if (number % 3 == 0) {
                    b = number / 3;
                }
                if (number % 2 == 0) {
                    c = number / 2;
                }
                if (a >= 1) next.add(a);
                if (b >= 1) next.add(b);
                if (c >= 1) next.add(c);
            }
            curr = next;
            cnt++;
        }

        System.out.println(cnt);
    }
}