/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 */
fun main() {
    val nums = arrayOf(2,7,11,5)
    val target = 9
    println(".twoSum Exists? : ${twoSum(nums, target)}")
}

fun twoSum(nums: Array<Int>, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for(i in nums.indices){
        val difference = target - nums[i]
        if(map.contains(difference)) {
            return intArrayOf(i, map.getOrDefault(difference, 0))
        } else {
            map[nums[i]] = i
        }
    }
    return intArrayOf()
}