import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        if (yellow == 1) {
            return new int[]{3, 3};
        }

        List<Integer> list = new ArrayList<>();

        for (int i = (int) Math.sqrt(yellow); i <= yellow; i++) {
            if (yellow % i == 0) {
                list.add(i);
            }
        }

        int[] ans = new int[2];
        for (int width : list) {
            int height = yellow / width;
            if (brown == 2 * (width + 2) + height * 2) {
                ans[0] = width + 2;
                ans[1] = height + 2;
            }
        }

        return ans;
    }
}