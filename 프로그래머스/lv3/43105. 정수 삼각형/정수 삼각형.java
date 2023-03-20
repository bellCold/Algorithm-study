import java.util.TreeSet;

class Solution {

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
        dp[0][0] = triangle[0][0];

        if (triangle.length == 1) {
            return triangle[0][0];
        }

        TreeSet<Integer> list = new TreeSet<>();

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 양 끝일 경우와 아닌 경우
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }

                // 맨 끝이면 이제 넣어준다.
                if (i == triangle.length - 1) {
                    list.add(dp[i][j]);
                }
            }
        }

        return list.last();
    }

}