import java.util.*;

/**
 * Two Pointer Technique Examples
 *
 * The two-pointer technique is an efficient approach for solving problems
 * involving arrays or lists. It uses two pointers to traverse the data structure
 * in a coordinated way, often reducing time complexity from O(n²) to O(n).
 */
public class TwoPointerExamples {

    /**
     * Example 1: Two Sum in Sorted Array
     * Given a sorted array, find two numbers that add up to a target.
     * Time: O(n), Space: O(1)
     */
    public int[] twoSumSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-indexed
            } else if (sum < target) {
                left++; // Need larger sum
            } else {
                right--; // Need smaller sum
            }
        }

        return new int[]{-1, -1}; // Not found
    }

    /**
     * Example 2: Remove Duplicates from Sorted Array
     * Remove duplicates in-place and return the new length.
     * Time: O(n), Space: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0; // Points to last unique element

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1; // Length of unique elements
    }

    /**
     * Example 3: Container With Most Water
     * Find two lines that together with x-axis form a container with most water.
     * Time: O(n), Space: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Example 4: Valid Palindrome
     * Check if a string is a palindrome (ignoring non-alphanumeric characters).
     * Time: O(n), Space: O(1)
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Example 5: Three Sum (Finding triplets that sum to zero)
     * Uses two pointers after fixing one element.
     * Time: O(n²), Space: O(1) excluding output
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort first: O(n log n)

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            // Two pointer approach for remaining two numbers
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * Example 6: Move Zeros
     * Move all zeros to the end while maintaining relative order.
     * Time: O(n), Space: O(1)
     */
    public void moveZeroes(int[] nums) {
        int slow = 0; // Position for next non-zero element

        // Move all non-zero elements forward
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // Fill remaining positions with zeros
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    /**
     * Example 7: Reverse String
     * Reverse a character array in-place.
     * Time: O(n), Space: O(1)
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * Example 8: Squares of Sorted Array
     * Given sorted array (may include negative numbers),
     * return sorted array of squares.
     * Time: O(n), Space: O(n)
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1; // Fill from end

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
            pos--;
        }

        return result;
    }

    // Main method with test cases
    public static void main(String[] args) {
        TwoPointerExamples examples = new TwoPointerExamples();

        // Test 1: Two Sum
        System.out.println("=== Test 1: Two Sum in Sorted Array ===");
        int[] arr1 = {2, 7, 11, 15};
        int[] result1 = examples.twoSumSorted(arr1, 9);
        System.out.println("Input: [2,7,11,15], target=9");
        System.out.println("Output: [" + result1[0] + "," + result1[1] + "]\n");

        // Test 2: Remove Duplicates
        System.out.println("=== Test 2: Remove Duplicates ===");
        int[] arr2 = {1, 1, 2, 2, 3, 4, 4, 5};
        int len = examples.removeDuplicates(arr2);
        System.out.print("Input: [1,1,2,2,3,4,4,5]\nOutput length: " + len + ", Array: [");
        for (int i = 0; i < len; i++) {
            System.out.print(arr2[i] + (i < len - 1 ? "," : ""));
        }
        System.out.println("]\n");

        // Test 3: Max Area
        System.out.println("=== Test 3: Container With Most Water ===");
        int[] arr3 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = examples.maxArea(arr3);
        System.out.println("Input: [1,8,6,2,5,4,8,3,7]");
        System.out.println("Output: " + maxArea + "\n");

        // Test 4: Palindrome
        System.out.println("=== Test 4: Valid Palindrome ===");
        String str = "A man, a plan, a canal: Panama";
        boolean isPalin = examples.isPalindrome(str);
        System.out.println("Input: \"" + str + "\"");
        System.out.println("Output: " + isPalin + "\n");

        // Test 5: Three Sum
        System.out.println("=== Test 5: Three Sum ===");
        int[] arr5 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = examples.threeSum(arr5);
        System.out.println("Input: [-1,0,1,2,-1,-4]");
        System.out.println("Output: " + threeSum + "\n");

        // Test 6: Move Zeroes
        System.out.println("=== Test 6: Move Zeroes ===");
        int[] arr6 = {0, 1, 0, 3, 12};
        examples.moveZeroes(arr6);
        System.out.print("Input: [0,1,0,3,12]\nOutput: [");
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + (i < arr6.length - 1 ? "," : ""));
        }
        System.out.println("]\n");

        // Test 7: Reverse String
        System.out.println("=== Test 7: Reverse String ===");
        char[] arr7 = {'h', 'e', 'l', 'l', 'o'};
        examples.reverseString(arr7);
        System.out.print("Input: ['h','e','l','l','o']\nOutput: [");
        for (int i = 0; i < arr7.length; i++) {
            System.out.print("'" + arr7[i] + "'" + (i < arr7.length - 1 ? "," : ""));
        }
        System.out.println("]\n");

        // Test 8: Sorted Squares
        System.out.println("=== Test 8: Squares of Sorted Array ===");
        int[] arr8 = {-4, -1, 0, 3, 10};
        int[] result8 = examples.sortedSquares(arr8);
        System.out.print("Input: [-4,-1,0,3,10]\nOutput: [");
        for (int i = 0; i < result8.length; i++) {
            System.out.print(result8[i] + (i < result8.length - 1 ? "," : ""));
        }
        System.out.println("]");
    }
}
