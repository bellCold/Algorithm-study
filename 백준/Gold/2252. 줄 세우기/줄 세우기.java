import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static ArrayList<Integer>[] compare;
    static int[] height;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] order = br.readLine().split(" ");
        int students = Integer.parseInt(order[0]);
        int compareCount = Integer.parseInt(order[1]);

        compare = new ArrayList[students + 1];
        height = new int[students + 1];
        answer = new ArrayList<>();

        for (int i = 1; i < students + 1; i++) {
            compare[i] = new ArrayList<>();
        }

        for (int i = 0; i < compareCount; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            compare[a].add(b);
            height[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (Integer integer : compare[now]) {
                height[integer]--;
                if (height[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }

    }


}
