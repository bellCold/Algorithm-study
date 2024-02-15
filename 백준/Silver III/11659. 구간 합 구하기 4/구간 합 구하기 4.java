import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String size = st.nextToken();
        int answer = Integer.parseInt(st.nextToken());

        int[] S = new int[Integer.parseInt(size) + 1];
        S[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < S.length; i++) {
            int input = Integer.parseInt(st.nextToken());
            S[i] = input + S[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(S[right] - S[left - 1]).append("\n");
        }

        System.out.println(sb);
    }

}
