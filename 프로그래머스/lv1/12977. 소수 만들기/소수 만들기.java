import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static int count = 0;
    static int divide = 0;

    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        findDecimal(list);
        return count;
    }

    // 1, 2, 7, 6, 4
    private void findDecimal(List<Integer> list) {
        for (int number : list) {
            int count = 1;
            while (count <= number) {
                if (number % count == 0) {
                    divide++;
                }
                count++;
            }
            if (divide == 2) {
                Solution.count++;
            }
            divide = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 7, 6, 4}));
    }
}