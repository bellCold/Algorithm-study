import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();
        double[] array = new double[Integer.parseInt(size)];

        String request = br.readLine();
        StringTokenizer st = new StringTokenizer(request);

        double maxScore = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(st.nextToken());
            if (array[i] > maxScore) {
                maxScore = array[i];
            }
        }

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] / maxScore * 100;
            sum += array[i];
        }

        System.out.println(sum / array.length);
    }

}
