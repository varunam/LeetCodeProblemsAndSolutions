/**
 * 202. Happy Number
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
fun main() {
    println(isHappy(3))
}

fun isHappy(n: Int): Boolean {
    val seenNumbers = hashSetOf<Int>()
    var number = n

    while (number != 1 && seenNumbers.contains(number).not()) {
        seenNumbers.add(number)
        number = findTotal(number)
    }

    return number == 1
}

fun findTotal(number: Int): Int {
    var num = number
    var total = 0
    while (num > 0) {
        val d = num % 10
        total += d * d
        num /= 10
    }
    return total
}