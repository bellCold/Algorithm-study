import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 학점
        int total = 0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            String[] grades = br.readLine().split(" ");
            double score = Double.parseDouble(grades[1]);

            String grade = grades[2];
            double swapScore = 0;
            switch (grade) {
                case "A+":
                    swapScore = 4.5;
                    break;
                case "A0":
                    swapScore = 4.0;
                    break;
                case "B+":
                    swapScore = 3.5;
                    break;
                case "B0":
                    swapScore = 3.0;
                    break;
                case "C+":
                    swapScore = 2.5;
                    break;
                case "C0":
                    swapScore = 2.0;
                    break;
                case "D+":
                    swapScore = 1.5;
                    break;
                case "D0":
                    swapScore = 1.0;
                    break;
                case "F":
                    swapScore = 0.0;
                    break;
            }
            // P 인경우 계산에서 제외하기 위해
            if (grade.equals("P")) {
                continue;
            }

            // 총합
            total += score;
            // 학점 * 과목평점
            sum += score * swapScore;
        }

        System.out.println(sum / total);
    }
}


