import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s1 = br.readLine();
        int sum = s1.chars().map(Character::getNumericValue).sum();
        System.out.println(sum);
    }
}
