import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetMovie = Integer.parseInt(br.readLine());

        int count = 0;
        int number = 666;
        while (count != targetMovie) {
            if (String.valueOf(number).contains("666")){
                count++;
            }
            number++;
        }

        System.out.println(number - 1);
    }
}