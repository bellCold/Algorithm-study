import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n <= 2) {
            System.out.println(1);
            return;
        } else {
            int a = 0;
            int b = 1;
            int c = 1;
            for (int i = 3; i <= n; i++) {
                a = b + c;
                c = b;
                b = a;
            }
            System.out.println(a);
        }
    }

}
