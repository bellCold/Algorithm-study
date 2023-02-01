import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];
        boolean[][] visit = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String[] order = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(order[j]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                int count = findSector(map, visit, col, row);
                if (count > 0) {
                    ans.add(count);
                }
            }
        }

        System.out.println(ans.size());
        ans.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }

    private static int findSector(int[][] map, boolean[][] visit, int col, int row) {
        if (col < 0 || row < 0 || col == map.length || row == map.length) {
            return 0;
        }

        if (visit[col][row] || map[col][row] == 0) {
            return 0;
        }
        visit[col][row] = true;

        int count = map[col][row];

        count += findSector(map, visit, col + 1, row);
        count += findSector(map, visit, col - 1, row);
        count += findSector(map, visit, col, row + 1);
        count += findSector(map, visit, col, row - 1);
        return count;
    }
}