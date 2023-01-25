import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nArray = getInts(br);
        Arrays.sort(nArray);

        int[] mArray = getInts(br);

        StringBuilder sb = new StringBuilder();
        for (int j : mArray) {
            int existStatus = existNumber(j, nArray);
            sb.append(existStatus).append("\n");
        }

        System.out.println(sb);

    }

    private static int existNumber(int key, int[] nArray) {
        int mid;
        int low = 0;
        int high = nArray.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == nArray[mid]) {
                return 1;
            } else if (key < nArray[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }


    private static int[] getInts(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nIntArray = new int[n];
        String[] An = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nIntArray[i] = Integer.parseInt(An[i]);
        }
        return nIntArray;
    }
}