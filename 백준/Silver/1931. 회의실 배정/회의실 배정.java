import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] A = new int[size][2];


        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            A[i][0] = a;
            A[i][1] = b;
        }

        Arrays.sort(A, (S, E) -> {
            // 종료시점으로 정렬 같다면 시작시간
            if (S[1] == E[1]) {
                return S[0] - E[0];
            }
            return S[1] - E[1];
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < size; i++) {
            // 끝나는시간 갱신
            if (A[i][0] >= end) {
                end = A[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
