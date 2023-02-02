import java.util.ArrayList;
import java.util.List;
/**
 * DFS 
 */
class Solution {

    public int[] solution(String[] maps) {
        char[][] map = new char[maps.length][];
        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        // map create
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        List<Integer> ans = new ArrayList<>();
        for (int col = 0; col < maps.length; col++) {
            for (int row = 0; row < maps[0].length(); row++) {
                int width = findSector(map, visit, col, row);
                if (width > 0) {
                    ans.add(width);
                }
            }
        }

        return ans.size() != 0 ? ans.stream().sorted().mapToInt(value -> value).toArray() : new int[]{-1};

    }

    private int findSector(char[][] map, boolean[][] visit, int col, int row) {
        if (col < 0 || row < 0 || col == map.length || row == map[0].length) {
            return 0;
        }

        if (visit[col][row] || map[col][row] == 'X') {
            return 0;
        }

        visit[col][row] = true;

        int rst = map[col][row] - '0';

        rst += findSector(map, visit, col - 1, row);
        rst += findSector(map, visit, col + 1, row);
        rst += findSector(map, visit, col, row - 1);
        rst += findSector(map, visit, col, row + 1);

        return rst;
    }
}
