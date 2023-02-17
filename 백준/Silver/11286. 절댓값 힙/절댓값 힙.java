import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Abs implements Comparable<Abs> {
        int x;
        int y;

        public Abs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Abs o) {
            if (this.y == o.y) return this.x - o.x;
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Abs> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().x).append("\n");
                }
            } else {
                pq.add(new Abs(number, Math.abs(number)));
            }
        }
        System.out.println(sb);
    }

}
