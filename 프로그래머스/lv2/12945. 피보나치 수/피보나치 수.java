import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        BigInteger answer = new BigInteger("0");
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("0");
        for (int i = 2; i <= n; i++) {
            answer = a.add(b);
            b = a;
            a = answer;
        }
        return answer.remainder(new BigInteger("1234567")).intValue();
    }
    
}
