import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class Motel {
        private LocalTime in;
        private LocalTime out;

        public Motel(LocalTime in, LocalTime out) {
            this.in = in;
            this.out = out;
        }

        public LocalTime getIn() {
            return in;
        }

        public LocalTime getOut() {
            return out;
        }
    }

    public int solution(String[][] book_time) {
        PriorityQueue<Motel> list = new PriorityQueue<>(Comparator.comparing(Motel::getIn));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (String[] strings : book_time) {
            LocalTime checkin = LocalTime.from(formatter.parse(strings[0]));
            LocalTime checkout = LocalTime.from(formatter.parse(strings[1]));

            list.add(new Motel(checkin, checkout));
        }

        int maxUseRoom = 0;
        PriorityQueue<Motel> useList = new PriorityQueue<>(Comparator.comparing(Motel::getOut));
        while (!list.isEmpty()) {
            Motel motel = list.poll();
            if (useList.isEmpty()) {
                useList.add(motel);
            } else {
                if (useList.peek().getOut().plusMinutes(9).isBefore(motel.in)) {
                    useList.poll();
                    useList.add(motel);
                } else {
                    useList.add(motel);
                }
            }

            if (maxUseRoom < useList.size()) {
                maxUseRoom = useList.size();
            }
        }
        return maxUseRoom;
    }
}