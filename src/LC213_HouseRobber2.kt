fun main() {
    val list = intArrayOf(1)
    println(list)
    val result = rob(list)
    println(result)
}

private fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]

    val option1 = robLinear(nums.copyOfRange(0, nums.size - 1))
    val option2 = robLinear(nums.copyOfRange(1, nums.size))

    return maxOf(option1, option2)
}

private fun robLinear(nums: IntArray): Int {
    var prev2 = 0
    var prev1 = 0

    for (i in 0..nums.lastIndex) {
        val curr = maxOf(prev1, nums[i] + prev2)
        prev2 = prev1
        prev1 = curr
    }

    return prev1
}