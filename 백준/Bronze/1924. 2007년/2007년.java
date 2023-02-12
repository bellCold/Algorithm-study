import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);

        LocalDate localDate = LocalDate.of(2007, month, day);
        System.out.println(localDate.getDayOfWeek().name().substring(0,3));
    }

}
