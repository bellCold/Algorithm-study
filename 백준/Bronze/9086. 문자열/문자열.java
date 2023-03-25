import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] split = br.readLine().split("");
            sb.append(split[0]).append(split[split.length - 1]).append("\n");
        }

        System.out.println(sb);
    }


}