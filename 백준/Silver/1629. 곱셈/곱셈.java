import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long result = powMod(A, B, C);
        System.out.println(result);
    }

    // Computes (base^exponent) % mod
    static long powMod(long base, long exponent, long mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) { // if exponent is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1; // divide exponent by 2
        }
        return result;
    }
}
