import java.util.List;

class Solution {
    public int solution(String[] babbling) {
        List<String> list = List.of("aya", "ye", "woo", "ma");
        int answer = 0;
        
        for (String word : babbling) {
            String temp = word;
            for (int i = 0; i < list.size(); i++) {
                temp = temp.replaceAll(list.get(i), " ");
            }

            if (temp.trim().equals("")) {
                answer++;
            }
        }
        return answer;
    }

}
