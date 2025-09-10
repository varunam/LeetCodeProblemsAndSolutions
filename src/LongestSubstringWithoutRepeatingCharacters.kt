import kotlin.math.max

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
fun main() {
    println("Length: ${lengthOfLongestSubstring("abcabcbb")}")
}

fun lengthOfLongestSubstringBruteForce(s: String): Int {
    var maxLength = 0

    for (i in 0 until s.length) {
        var subString = ""
        for (j in i until s.length) {
            if (subString.contains(s[j].toString()).not()) {
                subString += s[j].toString()
                if (maxLength < subString.length) {
                    maxLength = subString.length
                    println("Considering $subString")
                }
            } else {
                break
            }
        }
    }
    return maxLength
}

fun lengthOfLongestSubstring(s: String): Int {
    var start = 0
    var end = 0
    var maxLength = 0
    val hashMap = HashMap<Char, Int>()
    while(end != s.length) {
        val mapHasChar = hashMap.get(s[end])
        if(mapHasChar != null && mapHasChar >= start) {
            start = hashMap.get(s[end])!! + 1
        }
        maxLength = max(maxLength, end - start + 1)
        hashMap[s[end]] = end
        end++
    }
    return maxLength
}