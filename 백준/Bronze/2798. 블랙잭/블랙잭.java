import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cardCount = Integer.parseInt(st.nextToken());
        int targetNumber = Integer.parseInt(st.nextToken());

        int[] cartBuket = new int[cardCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCount; i++) {
            cartBuket[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < cartBuket.length - 2; i++) {
            for (int j = i + 1; j < cartBuket.length - 1; j++) {
                for (int k = j + 1; k < cartBuket.length; k++) {
                    int blackJackNumber = cartBuket[i] + cartBuket[j] + cartBuket[k];
                    if (blackJackNumber <= targetNumber && targetNumber - ans > targetNumber - blackJackNumber) {
                        ans = blackJackNumber;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}