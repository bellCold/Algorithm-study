import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparing(it -> it.value));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int V = Integer.parseInt(firstLine[0]);
        int E = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[K] = 0;

        for (int i = 0; i < E; i++) {
            String[] edges = br.readLine().split(" ");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            int w = Integer.parseInt(edges[2]);
            list[u].add(new Edge(v, w));
        }

        q.add(new Edge(K, 0));

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int vertex = current.vertex;
            if (visited[vertex]) {
                continue;
            } else {
                visited[vertex] = true;
            }

            for (Edge edges : list[current.vertex]) {
                int nextVertex = edges.vertex;
                int nextValue = edges.value;

                if (distance[nextVertex] > distance[vertex] + nextValue) {
                    distance[nextVertex] = distance[vertex] + nextValue;
                    q.add(new Edge(nextVertex, distance[nextVertex]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }

        }
    }

    static class Edge {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}

