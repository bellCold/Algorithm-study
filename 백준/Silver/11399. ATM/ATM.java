import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());

        int[] peopleArray = new int[people];
        int[] S = new int[people];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < peopleArray.length; i++) {
            peopleArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(peopleArray);

        S[0] = peopleArray[0];
        for (int i = 1; i < peopleArray.length; i++) {
            S[i] = peopleArray[i] + S[i - 1];
        }

        System.out.println(Arrays.stream(S).sum());
    }

}
