import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            String[] split = skill_tree.split("");
            Queue<String> queue = new LinkedList<>(Arrays.asList(split));
            String temp = "";
            for (int i = 0; i < split.length; i++) {
                String poll = queue.poll();
                if (skill.contains(poll)) {
                    temp += poll;
                }
            }
            int cnt = 0;
            for (int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i) == skill.charAt(i)) cnt++;
            }
            if (cnt == temp.length()) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int cbd = solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(cbd);
    }
}