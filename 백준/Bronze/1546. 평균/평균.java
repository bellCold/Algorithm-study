import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subjectNum = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        double[] arr = new double[subjectNum];
        for (int i = 0; i < subjectNum; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        double maxScore = Arrays.stream(arr).max().getAsDouble();
        double sum = Arrays.stream(arr).sum();
        double avg = sum / maxScore * 100 / subjectNum;
        System.out.println(avg);
    }
}

