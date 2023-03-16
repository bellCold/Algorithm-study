import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        return sides[0] - 1 + sides[1] - (sides[1] - sides[0]);
    }
}