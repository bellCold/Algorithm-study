import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> answer = new PriorityQueue<>();
    static int targetCipher;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targetCipher = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        while (!answer.isEmpty()) {
            System.out.println(answer.poll());
        }
    }

    private static void dfs(int number, int cipher) {
        if (cipher == targetCipher) {
            if (isSosu(number)) {
                answer.add(number);
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isSosu(number * 10 + i)) {
                dfs(number * 10 + i, cipher + 1);
            }
        }
    }

    private static boolean isSosu(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
