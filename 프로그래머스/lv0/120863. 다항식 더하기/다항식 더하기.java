import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String polynomial) {
        String[] orderList = polynomial.split(" \\+ ");

        List<String> xList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();

        for (String s : orderList) {
            if (s.contains("x")) {
                xList.add(s);
            } else {
                numberList.add(Integer.parseInt(s));
            }
        }

        StringBuilder ans = new StringBuilder();

        int oneX = 0;
        int anotherX = 0;

        for (String s : xList) {
            if (s.length() == 1) {
                oneX++;
            } else {
                String[] split = s.split("x");
                anotherX += Integer.parseInt(split[0]);
            }
        }

        int totalNumber = 0;
        for (Integer integer : numberList) {
            totalNumber += integer;
        }

        if (oneX + anotherX == 1) {
            ans.append("x");
            if (totalNumber != 0) {
                ans.append(" + ");
                ans.append(totalNumber);
            }
        } else if (oneX + anotherX != 0) {
            ans.append(oneX + anotherX);
            ans.append("x");
            if (totalNumber != 0) {
                ans.append(" + ");
                ans.append(totalNumber);
            }
        } else if (oneX + anotherX == 0) {
            ans.append(totalNumber);
        }
        
        return ans.toString();
    }
}