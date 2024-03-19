import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] order = br.readLine().split(" ");
            int calOrder = Integer.parseInt(order[0]);
            int a = Integer.parseInt(order[1]);
            int b = Integer.parseInt(order[2]);

            if (calOrder == 0) {
                union(a, b);
            } else if (calOrder == 1) {
                if (isSameGroup(a, b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean isSameGroup(int a, int b) {
        return find(a) == find(b);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a > b) {
                group[a] = b;
            } else {
                group[b] = a;
            }
        }
    }

    private static int find(int a) {
        if (group[a] == a) {
            return a;
        }
        return group[a] = find(group[a]);
    }

}
