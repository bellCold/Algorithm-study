import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);

        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int[] datum = data[i - 1];
            int dataTotal = 0;
            for (int j = 0; j < datum.length; j++) {
                dataTotal += datum[j] % i;
            }
            answer = answer ^ dataTotal;
        }
        return answer;
    }
    
}