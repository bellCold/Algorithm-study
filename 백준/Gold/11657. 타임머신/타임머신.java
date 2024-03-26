import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] distance;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int city = Integer.parseInt(firstLine[0]);
        int bus = Integer.parseInt(firstLine[1]);

        edges = new Edge[bus + 1];
        distance = new long[city + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < bus; i++) {
            String[] split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            int t = Integer.parseInt(split[2]);
            edges[i] = new Edge(s, e, t);
        }

        distance[1] = 0;

        for (int i = 1; i < city; i++) {
            for (int j = 0; j < bus; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean isExistNegativeNumber = false;

        for (int j = 0; j < bus; j++) {
            Edge edge = edges[j];
            if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                isExistNegativeNumber = true;
                break;
            }
        }

        if (!isExistNegativeNumber) {
            for (int i = 2; i <= city; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}

