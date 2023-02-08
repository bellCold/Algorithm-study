import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Car {
        int weight;
        int length;

        public Car(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Car> queue = new LinkedList<>();
        Queue<Car> traffic = new LinkedList<>();

        for (int truck_weight : truck_weights) queue.add(new Car(truck_weight, bridge_length));

        int answer = 0;
        int currWeight = 0;

        while (!traffic.isEmpty() || !queue.isEmpty()) {
            answer++;

            if (traffic.isEmpty()) {
                Car car = queue.poll();
                currWeight += car.weight;
                traffic.add(car);
                continue;
            }

            traffic.forEach(value -> value.length--); //(4, 0)

            if (traffic.peek().length == 0) {
                currWeight -= traffic.poll().weight;
            }

            if (!queue.isEmpty() && currWeight + queue.peek().weight <= weight) {
                Car car = queue.poll();
                currWeight += car.weight; // 7
                traffic.add(car); // (4, 2)
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(2, 10, new int[]{1, 1});
        System.out.println("solution1 = " + solution1);
    }
}