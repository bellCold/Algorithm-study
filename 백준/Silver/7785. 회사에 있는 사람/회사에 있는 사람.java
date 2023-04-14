import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int logCount = Integer.parseInt(br.readLine());

        Map<String, String> log = new HashMap<>();

        for (int i = 0; i < logCount; i++) {
            String accessRoster = br.readLine();
            String[] s = accessRoster.split(" ");
            log.put(s[0], s[1]);
        }

        List<String> enter = log.entrySet().stream()
                .filter(value -> value.getValue().equals("enter"))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(toList());

        enter.forEach(System.out::println);
    }


}
