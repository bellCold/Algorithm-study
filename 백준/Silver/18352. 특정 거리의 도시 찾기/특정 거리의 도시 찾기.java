import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static int[] minDistance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int node = Integer.parseInt(firstLine[0]);
        int edge = Integer.parseInt(firstLine[1]);
        int distance = Integer.parseInt(firstLine[2]);
        int country = Integer.parseInt(firstLine[3]);

        map = new List[node + 1];
        for (int i = 1; i < node + 1; i++) {
            map[i] = new ArrayList<>();
        }
        minDistance = new int[node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            map[start].add(end);
        }

        BFS(country);

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < minDistance.length; i++) {
            if (minDistance[i] == distance) {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(result);

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void BFS(int country) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(country);
        visited[country] = true;
        while (!queue.isEmpty()) {
            Integer currCountry = queue.poll();
            for (Integer integer : map[currCountry]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    minDistance[integer] = minDistance[currCountry] + 1;
                    queue.add(integer);
                }
            }
        }
    }
}
