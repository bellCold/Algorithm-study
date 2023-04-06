import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        for (int i = 0; i < order.length(); i += 10) {
            if (i + 10 < order.length()) {
                System.out.println(order.substring(i, i + 10));
            } else {
                System.out.println(order.substring(i));
            }
        }
    }


}
