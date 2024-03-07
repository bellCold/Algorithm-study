import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] orderSplit = br.readLine().split(" ");
        BigInteger first = new BigInteger(orderSplit[0]);
        BigInteger second = new BigInteger(orderSplit[1]);

        BigInteger gcd = first.gcd(second);

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcd.longValue(); i ++) {
            sb.append("1");
        }

        System.out.println(sb);
    }

}
