import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] checkArr = new int[4];
    static int[] currArr = new int[4];
    static int ans = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] DNA = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        // A C G T 최소 조건 개수 배열셋팅
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }
        //CCTGGATTG
        for (int i = 0; i < s; i++) {
            if (i < p) {
                add(DNA, i);
            } else {
                char removeTarget = DNA[i - p];
                add(DNA, i);
                remove(removeTarget);
            }
            if (i >= p - 1) {
                checkDNA(checkArr, currArr);
            }
        }
        System.out.println(ans);
    }

    private static void remove(char removeTarget) {
        if (removeTarget == 'A') {
            currArr[0]--;
        } else if (removeTarget == 'C') {
            currArr[1]--;
        } else if (removeTarget == 'G') {
            currArr[2]--;
        } else if (removeTarget == 'T') {
            currArr[3]--;
        }
    }

    private static void add(char[] DNA, int i) {
        if (DNA[i] == 'A') {
            currArr[0]++;
        } else if (DNA[i] == 'C') {
            currArr[1]++;
        } else if (DNA[i] == 'G') {
            currArr[2]++;
        } else if (DNA[i] == 'T') {
            currArr[3]++;
        }
    }

    private static void checkDNA(int[] checkArr, int[] currArr) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (checkArr[i] > currArr[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            ans++;
        }
    }
}


