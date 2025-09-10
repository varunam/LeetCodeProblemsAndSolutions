import kotlin.text.iterator


/**
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 *
 * Output: 0
 *
 * Explanation:
 *
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 *
 * Example 2:
 *
 * Input: s = "loveleetcode"
 *
 * Output: 2
 *
 * Example 3:
 *
 * Input: s = "aabb"
 *
 * Output: -1
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

fun main() {
    println(firstUniqChar("aabb"))
}

fun firstUniqChar(s: String): Int {
    val hashMap = hashMapOf<Char, Int>()
    for (c in s) {
        hashMap[c] = hashMap.getOrDefault(c, 0) + 1
    }

    for (c in s) {
        if (hashMap.get(c) == 1) {
            return s.indexOf(c)
        }
    }
    return -1
}