import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        int intSize = Integer.parseInt(size);

        String request = br.readLine();
        String[] split = request.split("");

        int[] array = new int[intSize];

        for (int i = 0; i < intSize; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }

        System.out.println(result);
    }

}
