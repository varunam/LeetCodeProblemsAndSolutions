import java.util.Stack
import kotlin.math.min

fun main() {
    val minStack = MinStack()
    minStack.push(2)
    minStack.push(3)
    println(minStack.getMin())
    minStack.push(-1)
    println(minStack.getMin())
    minStack.push(-139)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.getMin())
}

class MinStack() {

    private val stack = Stack<Pair<Int, Int>>()

    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.push(Pair(`val`, `val`))
        } else {
            stack.push(Pair(`val`, min(`val`, stack.peek().second)))
        }
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return stack.peek().second
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
