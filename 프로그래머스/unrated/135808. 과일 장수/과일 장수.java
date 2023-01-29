import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int k, int m, int[] score) {
        Integer[] array = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Comparator.reverseOrder());
        int sum = 0;

        for (int i = m - 1; i < array.length; i = i + m) {
            sum += array[i] * m;
        }

        return sum;
    }
}