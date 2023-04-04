import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            }
        }

        AtomicInteger currWinCount = new AtomicInteger();
        Arrays.stream(lottos).forEach(value -> {
            for (int winNum : win_nums) {
                if (value == winNum) {
                    currWinCount.getAndIncrement();
                }
            }
        });

        int winCount = currWinCount.get();

        int[] answer = new int[2];

        int grade = 1;
        for (int i = 6; i >= 1; i--) {
            if (winCount + zeroCount == i) {
                answer[0] = grade;
            }
            grade++;
        }
        if (winCount + zeroCount == 0) {
            answer[0] = 6;
        }
        
        if (winCount == 1 || winCount == 0) {
            answer[1] = 6;
        } else if (winCount == 2) {
            answer[1] = 5;
        } else if (winCount == 3) {
            answer[1] = 4;
        } else if (winCount == 4) {
            answer[1] = 3;
        } else if (winCount == 5) {
            answer[1] = 2;
        } else {
            answer[1] = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int i : solution1) {
            System.out.println(i);
        }
    }

}