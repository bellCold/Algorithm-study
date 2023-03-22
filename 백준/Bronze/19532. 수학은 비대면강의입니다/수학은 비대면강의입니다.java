import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numberBucket = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            numberBucket[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (numberBucket[0] * i + numberBucket[1] * j == numberBucket[2] && numberBucket[3] * i + numberBucket[4] * j == numberBucket[5]) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}