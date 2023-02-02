import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String t, String p) {
        List<BigInteger> answer = new ArrayList<>();

        for (int i = 0; i <= t.length() - p.length(); i++) {
            answer.add(new BigInteger(t.substring(i, p.length() + i)));
        }
        int cnt = 0;
        for (BigInteger bigInteger : answer) {
            int i = new BigInteger(p).compareTo(bigInteger);
            if (i >= 0) {
                cnt ++;
            }
        }
        return cnt;
    }
}