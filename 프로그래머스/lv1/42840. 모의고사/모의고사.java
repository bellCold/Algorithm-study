import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        String one = "12345".repeat(2000);
        String two = "21232425".repeat(2000);
        String three = "3311224455".repeat(1000);
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {

            if (Integer.parseInt(String.valueOf(one.charAt(i))) == answers[i]) {
                cnt1++;
            }
            if (Integer.parseInt(String.valueOf(two.charAt(i))) == answers[i]) {
                cnt2++;
            }
            if (Integer.parseInt(String.valueOf(three.charAt(i))) == answers[i]) {
                cnt3++;
            }
        }
        int max = Math.max(cnt3, Math.max(cnt1, cnt2));

        List<Integer> ans = new ArrayList<>();
        if (max == cnt1) {
            ans.add(1);
        }
        if (max == cnt2) {
            ans.add(2);
        }
        if (max == cnt3) {
            ans.add(3);
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}