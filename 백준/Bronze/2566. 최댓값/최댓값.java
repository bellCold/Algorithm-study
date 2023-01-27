import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                if (max <= Integer.parseInt(split[j])) {
                    max = Integer.parseInt(split[j]);
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }

}