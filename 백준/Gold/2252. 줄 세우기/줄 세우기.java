import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] maps;
    static int[] zeros;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCount = Integer.parseInt(st.nextToken());
        int compareCount = Integer.parseInt(st.nextToken());

        maps = new ArrayList[studentCount + 1];
        zeros = new int[studentCount + 1];

        for (int i = 1; i <= studentCount; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < compareCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[a].add(b);
            zeros[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < zeros.length; i++) {
            if (zeros[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int next : maps[cur]) {
                zeros[next]--;
                if (zeros[next] == 0) {
                    queue.add(next);
                }
            }
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}

