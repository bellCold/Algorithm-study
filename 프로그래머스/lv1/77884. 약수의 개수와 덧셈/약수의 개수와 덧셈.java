import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right).map(value -> {
            int sqrt = (int) Math.sqrt(value);
            if (sqrt * sqrt == value) {
                value = value * -1;
            }
            return value;
        }).sum();
    }
}
