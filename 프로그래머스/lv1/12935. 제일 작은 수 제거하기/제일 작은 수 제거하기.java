import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            list.add(i);
        }

        int min = list.stream().min(Comparator.comparingInt(o -> o)).get();

        List<Integer> filterList = list.stream().filter(value -> value != min).collect(Collectors.toList());

        return filterList.size() == 0 ? new int[]{-1} : filterList.stream().mapToInt(Integer::intValue).toArray();
    }
}