class Solution {
    public int solution(int a, int b) {
        int max = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                max = i;
            }
        }
        int target = b / max;
        
        while (target % 2 == 0) {
            target /= 2;
        }
        while (target % 5 == 0) {
            target /= 5;
        }

        return target == 1 || target % 2 == 0 || target % 5 == 0 ? 1 : 2;
    }
}