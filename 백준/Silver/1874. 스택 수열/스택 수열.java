import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> in = new Stack<>();
        List<String> ans = new ArrayList<>();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            in.add(i);
            ans.add("+");
            while (!in.isEmpty() && in.peek() == array[count]) {
                in.pop();
                ans.add("-");
                count++;
            }
        }
        if (ans.size() != n * 2) {
            System.out.println("NO");
        } else {
            ans.forEach(System.out::println);
        }
    }
}


