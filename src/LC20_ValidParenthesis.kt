import java.util.Stack

fun main() {
    println(isValid("(){[}]"))
}

fun isValid(s: String): Boolean {
    val map = mapOf(')' to '(', ']' to '[', '}' to '{')
    val stack = Stack<Char>()

    for (c in s) {
        if (c in map.values) {
            stack.push(c)
        } else if (c in map.keys) {
            if (stack.isEmpty() || stack.pop() != map[c]) {
                return false
            }
        }
    }
    return stack.isEmpty()
}