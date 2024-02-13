import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static Map<String, Long> reportCountRepository = new HashMap<>();
    static Map<String, List<String>> reportList = new HashMap<>();
    static List<String> banMember = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        // init
        for (String name : id_list) {
            reportCountRepository.put(name, 0L);
            reportList.put(name, new ArrayList<>());
        }

        // report data set
        for (String order : report) {
            String[] input = order.split(" ");
            String A = input[0];
            String B = input[1];
            List<String> list = reportList.get(A);
            // 한번만 신고 count 적용하기 위함
            if (!list.contains(B)) {
                reportCountRepository.put(B, reportCountRepository.getOrDefault(B, 0L) + 1);
                reportList.get(A).add(B);
            }
        }

        for (Map.Entry<String, Long> stringLongEntry : reportCountRepository.entrySet()) {
            Long reportCount = reportCountRepository.get(stringLongEntry.getKey());
            if (reportCount >= k) {
                banMember.add(stringLongEntry.getKey());
            }
        }

        for (String s : id_list) {
            List<String> list = reportList.get(s);
            int count = 0;
            for (String banMemberName : banMember) {
                if (list.contains(banMemberName)) {
                    count++;
                }
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}