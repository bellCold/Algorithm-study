import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static Queue<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String target = city.toLowerCase();
            if (cache.contains(target)) {
                cache.remove(target);
                cache.add(target);
                answer++;
            } else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.add(target);
                answer += 5;
            }
        }

        return answer;
    }
}