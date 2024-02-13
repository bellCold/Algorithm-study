import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int elementCount = Integer.parseInt(firstLine[0]);
        int calculatorCount = Integer.parseInt(firstLine[1]);

        group = new int[elementCount + 1];

        for (int i = 0; i < elementCount + 1; i++) {
            group[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < calculatorCount; i++) {
            String[] order = br.readLine().split(" ");
            int calOrder = Integer.parseInt(order[0]);
            int a = Integer.parseInt(order[1]);
            int b = Integer.parseInt(order[2]);

            if (calOrder == 0) {
                union(a, b);
            }

            if (calOrder == 1) {
                if (isSameSubset(a, b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }

            }
        }
        System.out.println(sb);

    }

    private static boolean isSameSubset(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            group[b] = a;
        }

    }

    private static int find(int a) {
        if (a == group[a]) {
            return a;
        } else {
            return group[a] = find(group[a]);
        }
    }

}
