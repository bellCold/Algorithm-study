import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantedList = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantedList.put(want[i], number[i]);
        }

        Map<String, Integer> discountList = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String s = discount[i];
            discountList.put(s, discountList.getOrDefault(s, 0) + 1);
        }

        int answer = count(wantedList, discountList);
        if (discount.length == 10) {
            return answer;
        }

        for (int i = 10; i < discount.length; i++) {
            String addDiscountOrder = discount[i];
            String removeDisCountOrder = discount[i - 10];
            discountList.put(removeDisCountOrder, discountList.get(removeDisCountOrder) - 1);
            discountList.put(addDiscountOrder, discountList.getOrDefault(addDiscountOrder, 0) + 1);
            answer += count(wantedList, discountList);
        }
        return answer;
    }

    private int count(Map<String, Integer> wantedList, Map<String, Integer> discountList) {
        boolean flag = true;
        for (Map.Entry<String, Integer> entry : wantedList.entrySet()) {
            if (!discountList.containsKey(entry.getKey()) || discountList.get(entry.getKey()) < wantedList.get(entry.getKey())) {
                flag = false;
            } 
        }
        return flag ? 1 : 0;
    }
}