import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            setA.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            setB.add(b[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(setA));
        result.add(new ArrayList<>(setB));

        result.get(0).removeAll(setB);
        result.get(1).removeAll(setA);

        return result;
    }
}
