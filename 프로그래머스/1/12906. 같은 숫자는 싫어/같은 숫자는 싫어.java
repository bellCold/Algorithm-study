import java.util.*;

public class Solution {
    public Stack solution(int []arr) {
        Stack<Integer> ar = new Stack<>();
        for (int a : arr) {
            if (ar.isEmpty() || ar.peek() != a) {
                ar.add(a);
            }
        }
        return ar;
    }
}