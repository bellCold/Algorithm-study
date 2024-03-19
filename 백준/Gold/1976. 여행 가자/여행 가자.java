import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[][] dosi = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                dosi[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        int[] route = new int[m + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            route[i] = Integer.parseInt(split[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dosi[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int start = find(route[1]);

        for (int i = 2; i < route.length; i++) {
            if (start != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a > b) {
                parent[a] = b; 
            } else {
                parent[b] = a;
            }
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

}
