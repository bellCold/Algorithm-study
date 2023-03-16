class Solution {
    boolean solution(String str) {
        int flag = 0;
        for (char c : str.toCharArray()) {
            if (c == ')') {
                flag--;
            } else {
                flag++;
            }
            if (flag == -1) {
                return false;
            }
        }

        return flag == 0;
    }
}