import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());

        HashSet<Integer> curr = new HashSet<>();
        HashSet<Integer> next;

        curr.add(0);

        int cnt = 0;
        while (!curr.isEmpty()) {
            if (curr.contains(weight)) {
                break;
            }
            next = new HashSet<>();
            for (Integer integer : curr) {
                int a = integer + 5;
                int b = integer + 3;
                if (a <= weight) next.add(a);
                if (b <= weight) next.add(b);
            }
            curr = next;
            cnt++;
        }

        System.out.println(curr.isEmpty() ? -1 : cnt);
    }
}