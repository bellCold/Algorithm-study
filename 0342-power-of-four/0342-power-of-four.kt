class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        n.run {
            if (n <= 0) {
                return false
            }
        }.run {
            if (n == 1) {
                return true
            }
        }.run {
            if (n % 4 == 0) {
                return isPowerOfFour(n / 4)
            }
        }
        return false
    }
}