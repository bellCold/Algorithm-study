# Two Pointer Technique

## Overview

The **Two Pointer** technique is a common algorithmic pattern used to solve problems involving arrays, strings, or linked lists. It uses two pointers (indices) that traverse the data structure in a coordinated way, often reducing time complexity from O(n²) to O(n).

## When to Use Two Pointers

- Working with **sorted arrays** or **strings**
- Need to find pairs or triplets that satisfy certain conditions
- Need to **remove duplicates** or **rearrange elements**
- Problems involving **palindromes**
- Finding **subarrays** or **subsequences**
- **In-place operations** with minimal space complexity

## Common Patterns

### 1. Opposite Direction (Left-Right)
Two pointers start from both ends and move toward each other.

**Use cases:**
- Two Sum in sorted array
- Valid Palindrome
- Container with Most Water
- Reverse String

```java
int left = 0;
int right = array.length - 1;

while (left < right) {
    // Process elements at left and right
    // Move pointers based on condition
    left++;
    right--;
}
```

### 2. Same Direction (Slow-Fast)
Both pointers start from the same side and move in the same direction at different speeds.

**Use cases:**
- Remove duplicates from sorted array
- Move zeros to end
- Partition array

```java
int slow = 0;

for (int fast = 0; fast < array.length; fast++) {
    if (condition) {
        array[slow] = array[fast];
        slow++;
    }
}
```

### 3. Sliding Window with Two Pointers
Two pointers define a window that expands or contracts.

**Use cases:**
- Longest substring without repeating characters
- Minimum window substring
- Maximum sum subarray of size K

```java
int left = 0;

for (int right = 0; right < array.length; right++) {
    // Expand window by including array[right]

    while (windowNeedsToShrink) {
        // Shrink window from left
        left++;
    }

    // Update result based on current window
}
```

## Examples in This Repository

The `TwoPointerExamples.java` file contains 8 classic problems:

1. **Two Sum in Sorted Array** - Find two numbers that add up to target
2. **Remove Duplicates** - Remove duplicates from sorted array in-place
3. **Container With Most Water** - Find maximum area between vertical lines
4. **Valid Palindrome** - Check if string is palindrome
5. **Three Sum** - Find all unique triplets that sum to zero
6. **Move Zeroes** - Move all zeros to end while maintaining order
7. **Reverse String** - Reverse character array in-place
8. **Squares of Sorted Array** - Return sorted array of squares

## Time and Space Complexity

| Problem | Time Complexity | Space Complexity |
|---------|----------------|------------------|
| Two Sum (sorted) | O(n) | O(1) |
| Remove Duplicates | O(n) | O(1) |
| Container With Most Water | O(n) | O(1) |
| Valid Palindrome | O(n) | O(1) |
| Three Sum | O(n²) | O(1) |
| Move Zeroes | O(n) | O(1) |
| Reverse String | O(n) | O(1) |
| Sorted Squares | O(n) | O(n) |

## Key Advantages

1. **Efficiency**: Reduces time complexity compared to nested loops
2. **Space**: Often achieves O(1) space complexity
3. **Simplicity**: Easy to understand and implement
4. **In-place**: Many operations can be done without extra memory

## Running the Examples

```bash
cd two-pointer-examples
javac TwoPointerExamples.java
java TwoPointerExamples
```

## Tips for Solving Two Pointer Problems

1. **Identify if array/string is sorted** - This often hints at two pointers
2. **Consider what moving each pointer means** - What condition causes left to move? Right to move?
3. **Watch for edge cases** - Empty arrays, single elements, all duplicates
4. **Consider pre-sorting** - Sometimes sorting first enables two pointers
5. **Think about invariants** - What is always true between the pointers?

## Related Patterns

- **Sliding Window**: Extension of two pointers for subarray problems
- **Fast and Slow Pointers**: Used for linked list cycle detection
- **Binary Search**: Uses two pointers (left, right) with different logic

## Practice Problems

**Easy:**
- LeetCode 26: Remove Duplicates from Sorted Array
- LeetCode 125: Valid Palindrome
- LeetCode 344: Reverse String

**Medium:**
- LeetCode 15: Three Sum
- LeetCode 11: Container With Most Water
- LeetCode 167: Two Sum II (sorted array)

**Hard:**
- LeetCode 42: Trapping Rain Water
- LeetCode 76: Minimum Window Substring
