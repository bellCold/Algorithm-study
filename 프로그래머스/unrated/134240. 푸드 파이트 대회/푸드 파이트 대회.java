class Solution {
    public String solution(int[] food) {
        int[] order = new int[food.length];
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            order[i] = food[i] / 2;
            if (order[i] != 0) {
                answer = answer + String.valueOf(i).repeat(order[i]);
            }
        }

        answer += "0";

        for (int i = food.length - 1; i >= 1; i--) {
            if (order[i] != 0) {
                answer = answer + String.valueOf(i).repeat(order[i]);
            }
        }

        return answer;
    }
}