/**
 * 560. Subarray Sum Equals K
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
fun main() {
    val array = intArrayOf(9)
    val k = 90
    println("SubArray Count: ${subArraySunEqualsK(array, k)}")
}

fun subarraySumBruteForce(nums: IntArray, k: Int): Int {
    var count = 0
    for (i in 0..nums.lastIndex) {
        var sum = 0
        for (j in i..nums.lastIndex) {
            sum += nums[j]
            if (sum == k) {
                count++
            }
        }
    }
    return count
}

fun subArraySunEqualsK(nums: IntArray, k: Int): Int {
    val hashMap = HashMap<Int, Int>()
    hashMap[0] = 1
    var count = 0
    var prefixSum = 0
    for (n in nums) {
        prefixSum += n
        if (hashMap.containsKey(prefixSum - k)) {
            count += hashMap[prefixSum - k]!!
        }
        hashMap[prefixSum] = hashMap.getOrDefault(prefixSum, 0) + 1
    }
    return count
}