import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] video = new int[Integer.parseInt(st.nextToken())];
        int blueSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;
        for (int i = 0; i < video.length; i++) {
            video[i] = Integer.parseInt(st.nextToken());
            if (start < video[i]) {
                start = video[i];
            }
            end += video[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < video.length; i++) {
                if (sum + video[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += video[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > blueSize) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }


}
