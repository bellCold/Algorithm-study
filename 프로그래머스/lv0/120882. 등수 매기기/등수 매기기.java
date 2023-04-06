import java.util.*;

class Solution {
    static class Grade {
        private int index;
        private int score;

        public Grade(int index, int score) {
            this.index = index;
            this.score = score;
        }

        public int getIndex() {
            return index;
        }

        public int getScore() {
            return score;
        }
    }

    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Grade> grades = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(Grade::getScore)));

        for (int i = 0; i < score.length; i++) {
            grades.add(new Grade(i, score[i][0] + score[i][1]));
        }

        int rank = 1;
        int sameScorePeople = 0;
        int tempScore = grades.peek().getScore();

        while (!grades.isEmpty()) {
            Grade grade = grades.poll();
            if (tempScore == grade.getScore()) {
                answer[grade.index] = rank;
                sameScorePeople++;
            } else {
                rank += sameScorePeople;
                answer[grade.index] = rank;
                tempScore = grade.getScore();
                sameScorePeople = 1;
            }
        }
        return answer;
    }
    

}