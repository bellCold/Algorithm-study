import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] node;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int friendCount = Integer.parseInt(st.nextToken());

        node = new List[friendCount];
        visited = new boolean[friendCount];
        arrive = false;

        for (int i = 0; i < friendCount; i++) {
            node[i] = new ArrayList<>();
        }

        int edgeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            node[start].add(end);
            node[end].add(start);
        }

        for (int i = 0; i < node.length; i++) {
            findSection(i, 1);
            if (arrive) {
                break;
            }
        }

        System.out.println(arrive ? 1 : 0);
    }

    private static void findSection(int index, int depth) {
        if (arrive || depth == 5) {
            arrive = true;
            return;
        }
        visited[index] = true;

        for (Integer integer : node[index]) {
            if (!visited[integer]) {
                findSection(integer, depth + 1);
            }
        }
        visited[index] = false;
    }


}
