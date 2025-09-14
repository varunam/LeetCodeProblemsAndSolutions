/**
 * Problem: House Robber (LeetCode 198)
 *
 * Background:
 * ------------
 * This is a classic **Dynamic Programming (DP)** problem.
 *
 * It is very similar to Fibonacci numbers:
 *   - Fibonacci recurrence: fib[i] = fib[i-1] + fib[i-2]
 *   - House Robber recurrence: dp[i] = max(dp[i-1], nums[i] + dp[i-2])
 *
 * Why similar? Because:
 *   - At each step, the decision depends on the two previous results.
 *   - Like Fibonacci grows by adding two previous numbers,
 *     here we "decide" between two options using the two previous dp states.
 *
 * Problem Restatement:
 * ---------------------
 * You are given an array `nums` where nums[i] is the amount of money in house i.
 * You cannot rob two adjacent houses. Return the maximum amount of money you can rob.
 *
 * Approach 1 (DP Array):
 * ----------------------
 * We use an array dp[] where:
 *   dp[i] = maximum money that can be robbed from houses [0..i].
 *
 * Recurrence:
 *   dp[i] = max(dp[i-1], nums[i] + dp[i-2])
 *
 * Base cases:
 *   dp[0] = nums[0]
 *   dp[1] = max(nums[0], nums[1])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Approach 2 (Optimized Space):
 * -----------------------------
 * Observation: To calculate dp[i], we only need dp[i-1] and dp[i-2].
 * So we don’t need the entire dp array.
 * We can keep just two variables:
 *   prev1 = dp[i-1]
 *   prev2 = dp[i-2]
 *
 * Then update them iteratively:
 *   curr = max(prev1, nums[i] + prev2)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
fun main() {
    val values = intArrayOf(2, 7, 9, 3, 1)
    val result = rob(values)
    println("Result: $result")
}

private fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]

    var prev2 = nums[0]
    var prev1 = maxOf(nums[0], nums[1])

    for (i in 2..nums.lastIndex) {
        val curr = maxOf(prev1, nums[i] + prev2)
        prev2 = prev1
        prev1 = curr
    }

    return prev1
}