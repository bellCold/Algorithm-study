import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ints = new int[N];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ints);

        StringBuilder sb = new StringBuilder();
        for (int anInt : ints) {
            sb.append(anInt).append("\n");
        }

        System.out.println(sb);
    }

}
