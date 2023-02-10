import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int N = nums.length / 2; // 2

        if (list.size() > N) {  // 3 2
            return N;
        } else
            return list.size();
    }
    
}