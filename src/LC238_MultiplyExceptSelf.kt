/**
 * 238. Product of Array Except Self
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 */
fun main() {
    val array = arrayOf(-1, 1, 0, -3, 3)
    val result = productExceptSelfOmegaN(array)
    // now print the values inside the array result
    result.forEach { print("$it-") }
}

fun productExceptSelfBruteForce(nums: Array<Int>): IntArray {
    val array = IntArray(nums.size) { 1 }
    for (i in 0 until nums.size) {
        for (j in 0 until nums.size) {
            if (i == j) continue
            array[j] = array[j] * nums[i]
        }
    }
    return array
}

fun productExceptSelfOmegaN(nums: Array<Int>): IntArray {
    val finalArray = IntArray(nums.size) { 1 }
    for (i in 1 until nums.size) {
        finalArray[i] = finalArray[i - 1] * nums[i - 1]
    }

    var suffix = 1
    for (i in nums.size - 2 downTo 0) {
        suffix *= nums[i + 1]
        finalArray[i] = suffix * finalArray[i]
    }

    return finalArray
}