/**
 * Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 *
 * The test cases are generated such that the answer is always unique.
 *
 * You may return the output in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,3,3], k = 2
 *
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [7,7], k = 1
 *
 * Output: [7]
 * Constraints:
 *
 * 1 <= nums.length <= 10^4.
 * -1000 <= nums(i) <= 1000
 * 1 <= k <= number of distinct elements in nums.
 */
fun main() {
    val nums = arrayOf(1)
    val k = 1
    val result = getTopKFrequentElements(nums, k)
    result.forEach { println(it) }
}

fun getTopKFrequentElements(array: Array<Int>, n: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    array.forEach {
        if (map.containsKey(it)) {
            map[it] = map.getOrDefault(it, 0) + 1
        } else {
            map[it] = 1
        }
    }

    val frequencyArray = MutableList(array.size) { hashSetOf<Int>() }
    array.forEach { number ->
        val frequency = map.getOrDefault(number, 0)
        frequencyArray[frequency].add(number)
    }

    val resultArray = mutableListOf<Int>()
    var k = n
    for (i in frequencyArray.size - 1 downTo 0) {
        if (frequencyArray[i].isNotEmpty()) {
            frequencyArray[i].forEach { resultArray.add(it) }
            k--
            if (k == 0) {
                break
            }
        }
    }
    return resultArray.toIntArray()
}