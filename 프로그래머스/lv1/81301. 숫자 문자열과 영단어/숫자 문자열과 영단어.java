import java.util.List;

class Solution {
    public int solution(String s) {
        List<String[]> list = List.of(new String[]{"zero", "0"}, new String[]{"one", "1"}, new String[]{"two", "2"}, new String[]{"three", "3"}, new String[]{"four", "4"}, new String[]{"five", "5"}, new String[]{"six", "6"}, new String[]{"seven", "7"}, new String[]{"eight", "8"}, new String[]{"nine", "9"});
        for (String[] number : list) {
            s = s.replaceAll(number[0], number[1]);
        }

        return Integer.parseInt(s);
    }
}