import kotlin.text.iterator

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 */
fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = getGroupAnagramOptimised(strs)
    result.forEach {
        println(it)
    }
}

/**
 * Brute-force approach
 */
fun getGroupAnagram(receivedList: Array<String>): List<List<String>> {
    val overAllAnagramList = mutableListOf<List<String>>()
    val list = receivedList.toMutableList()
    while (list.isNotEmpty()) {
        val i = 0
        val anagramList = mutableListOf<String>()
        anagramList.add(list[i])
        for (j in i + 1 until list.size) {
            val isValidAnagram = isValidAnagram(list[i], list[j])
            if (isValidAnagram) {
                anagramList.add(list[j])
            }
        }
        overAllAnagramList.add(anagramList)
        list.removeAll(anagramList)
    }
    return overAllAnagramList
}

fun getGroupAnagramOptimised(receivedList: Array<String>): List<List<String>> {
    val hashMap = hashMapOf<List<Int>, MutableList<String>>()
    for (str in receivedList) {
        val list = MutableList(26) { 0 }
        for (char in str) {
            list[char - 'a']++
        }
        hashMap.getOrPut(list) { mutableListOf() }.add(str)
    }
    return hashMap.values.toList()
}
