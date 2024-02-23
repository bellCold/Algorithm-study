import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int numCount = Integer.parseInt(split[0]);
        int index = Integer.parseInt(split[1]);
        int[] ints = new int[numCount];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ints);

        System.out.println(ints[index - 1]);
    }

}
