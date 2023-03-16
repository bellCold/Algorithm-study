class Solution {
    public int solution(int n) {
        String ternaryNumber = Integer.toString(n, 3);
        String[] split = ternaryNumber.split("");
        String reverseTernaryNumber = "";
        for (int i = split.length - 1; i >= 0; i--) {
            reverseTernaryNumber += split[i];
        }

        return Integer.parseInt(reverseTernaryNumber, 3);
    }
}