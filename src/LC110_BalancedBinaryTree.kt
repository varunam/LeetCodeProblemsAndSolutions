import kotlin.math.abs

fun main() {
    val tree = createTree(listOf(1, 2, 3, 4, 5, 6, 7, 8))
    printTree(tree)
    println(isBalanced(tree))
}

private fun isBalanced(node: TreeNode?): Boolean {
    return check(node) != -1
}

private fun check(root: TreeNode?): Int {
    if (root == null) return 0

    val left = check(root.left)
    if(left == -1) return -1

    val right = check(root.right)
    if(right == -1) return -1

    if(abs(left - right) > 1) return -1

    return maxOf(left, right) + 1
}