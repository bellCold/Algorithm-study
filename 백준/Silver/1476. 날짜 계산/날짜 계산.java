import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int year = 0;
        int earth = 0;
        int sun = 0;
        int moon = 0;
        while (true) {
            earth++;
            sun++;
            moon++;
            year++;
            if (e == earth && s == sun && m == moon) {
                break;
            }
            if (earth == 15) {
                earth = 0;
            }
            if (sun == 28) {
                sun = 0;
            }
            if (moon == 19) {
                moon = 0;
            }
        }

        System.out.println(year);

    }
}
