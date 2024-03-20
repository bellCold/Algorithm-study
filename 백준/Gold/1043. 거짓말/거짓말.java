import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int peopleCount = Integer.parseInt(st.nextToken()); // 사람수
        parent = new int[peopleCount + 1];
        for (int i = 1; i <= peopleCount; i++) {
            parent[i] = i;
        }
        int partyCount = Integer.parseInt(st.nextToken()); // 파티수

        st = new StringTokenizer(br.readLine());
        int trueCount = Integer.parseInt(st.nextToken()); // 신뢰 사람 수
        int[] truePeopleArray = new int[trueCount];

        for (int i = 0; i < trueCount; i++) {
            truePeopleArray[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[partyCount];
        for (int i = 0; i < partyCount; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyPeopleCount = Integer.parseInt(st.nextToken()); // 파티 참석인원 수
            for (int j = 0; j < partyPeopleCount; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < party.length; i++) {
            int present = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(present, party[i].get(j));
            }
        }

        int result = 0;
        for (int i = 0; i < partyCount; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0 ; j < truePeopleArray.length; j++) {
                if (isSameGroup(cur, truePeopleArray[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                result++;
            }
        }
        System.out.println(result);
    }


    private static boolean isSameGroup(int a, int target) {
        return find(a) == find(target);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
        }

    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}

