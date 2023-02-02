import java.util.HashSet;
/**
 * 최소 횟수 찾기
 */
class Solution {
    public int solution(int x, int y, int n) {
        int cnt = 0;
        HashSet<Integer> curr = new HashSet<>();
        HashSet<Integer> next;
        curr.add(x);

        while (!curr.isEmpty()) {
            if (curr.contains(y))
                return cnt;
            next = new HashSet<>();
            for (int val : curr) {
                int pVal = val + n;
                int dVal = val * 2;
                int tVal = val * 3;
                if (pVal <= y) next.add(pVal);
                if (dVal <= y) next.add(dVal);
                if (tVal <= y) next.add(tVal);
            }
            curr = next;
            cnt++;
        }
        return -1;
    }
}
