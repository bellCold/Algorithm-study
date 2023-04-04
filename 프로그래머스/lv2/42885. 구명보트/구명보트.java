import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] people, int limit) {
       Arrays.sort(people);
        int boatCount = 0;
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            boatCount++;
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
        }
        return boatCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{70, 50, 80, 50}, 100);
        System.out.println("solution1 = " + solution1);
    }
}