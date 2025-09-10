import kotlin.text.iterator


/**
 * 76. Minimum Window Substring
 * Hard
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 */
fun main() {
    val string = minWindow("ADOBECODEBANC", "ABC")
    println(string)
}

fun minWindow(s: String, t: String): String {
    if (t.length > s.length) return ""

    // Step 1: Build the 'need' map from t, like your shopping list in the supermarket analogy 🛒
    val hashMap = mutableMapOf<Char, Int>()
    for (ch in t) {
        hashMap[ch] = hashMap.getOrDefault(ch, 0) + 1
    }

    // Variables to track the sliding window
    var left = 0
    var right = 0
    var required = t.length // total characters we need to satisfy
    var minLen = Int.MAX_VALUE
    var minStart = 0

    // Step 2: Expand window using 'right' pointer
    while (right < s.length) {
        val chRight = s[right]
        // If this character is needed, reduce the requirement
        if (hashMap.getOrDefault(chRight, 0) > 0) {
            required--
        }
        // Update the need map—even if it's zero or negative, we're tracking surplus characters too
        hashMap[chRight] = hashMap.getOrDefault(chRight, 0) - 1
        right++

        // Step 3: Once we've satisfied all characters, shrink window from 'left'
        while (required == 0) {
            // Update result if this window is smaller
            if (right - left < minLen) {
                minLen = right - left
                minStart = left
            }

            val chLeft = s[left]
            // If this character is in t, increasing its count might make the window invalid
            hashMap[chLeft] = hashMap.getOrDefault(chLeft, 0) + 1
            if (hashMap[chLeft]!! > 0) {
                required++
            }
            left++
        }
    }

    return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLen)
}

