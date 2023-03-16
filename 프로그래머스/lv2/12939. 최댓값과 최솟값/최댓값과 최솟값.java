import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> collect = Arrays.stream(s.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        return collect.get(0) + " " + collect.get(collect.size() - 1);
    }
}