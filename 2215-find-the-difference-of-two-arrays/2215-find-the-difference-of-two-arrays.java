import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        List<Integer> remove = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }

        for (int i : nums2) {
            list2.add(i);
        }

        for (Integer integer : list1) {
            if (list2.contains(integer)) {
                remove.add(integer);
            }
        }

        for (Integer integer : remove) {
            list1.remove(integer);
            list2.remove(integer);
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(list1));
        answer.add(new ArrayList<>(list2));
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> difference = solution.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
        for (List<Integer> integers : difference) {
            System.out.println(integers);
        }

    }
}