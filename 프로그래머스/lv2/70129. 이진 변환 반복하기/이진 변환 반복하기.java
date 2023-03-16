import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {

        int removeZeroCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            if (s.contains("0")) {
                zeroCount += (int) Arrays.stream(s.split("")).filter(value -> value.equals("0")).count();
                s = Arrays.stream(s.split("0")).collect(Collectors.joining());
            }
            s = Integer.toBinaryString(s.length());
            removeZeroCount++;
        }

        return new int[]{removeZeroCount, zeroCount};
    }
}