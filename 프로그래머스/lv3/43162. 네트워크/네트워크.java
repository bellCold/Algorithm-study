import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer>[] node;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {

        node = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            int[] computer = computers[i];
            for (int j = 0; j < computer.length; j++) {
                if (i != j && computer[j] == 1) {
                    node[i + 1].add(j + 1);
                    node[j + 1].add(i + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                findSector(i);
                answer++;
            }
        }

        return answer;
    }
    

    private void findSector(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;

        for (int num : node[i]) {
            findSector(num);
        }
    }
    
}