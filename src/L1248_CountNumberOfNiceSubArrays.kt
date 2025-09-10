fun main() {
    val array = arrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2)
    val k = 2
    println("Number of Nice Sub-Arrays: ${numberOfSubarrays(array, k)}")
}

fun numberOfSubarrays(nums: Array<Int>, k: Int): Int {
    var prefixSum = 0
    var count = 0
    val hashMap = HashMap<Int, Int>()
    hashMap[0] = 1

    for (num in nums) {
        val n = if (num % 2 == 0) 0 else 1
        prefixSum += n
        if (hashMap.contains(prefixSum - k)) {
            count += hashMap[prefixSum - k]!!
        }
        hashMap[prefixSum] = hashMap.getOrDefault(prefixSum, 0) + 1
    }
    return count
}

fun numberOfSubarraysBruteForce(nums: Array<Int>, x: Int): Int {
    var count = 0
    for (i in 0..nums.size) {
        for (j in i until nums.size) {
            val subArray = nums.sliceArray(i..j)
            var oddNumbersCount = 0
            for (k in 0 until subArray.size) {
                if (subArray[k] % 2 == 1) {
                    oddNumbersCount++
                }
            }
            if (oddNumbersCount == x) {
                count++
            }
        }
    }
    return count
}