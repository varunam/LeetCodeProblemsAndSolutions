/**
 * Explanation Video: https://www.youtube.com/watch?v=Hr5cWUld4vU
 */
fun main() {
    val lc124 = LC124_BinaryTreeMaximumPathSum()
    val tree = createTree(listOf(-10, 9, 20, null, null, 15, 7))
    printTree(tree)
    val result = lc124.maxPathSum(tree)
    println("Result: $result")
}

class LC124_BinaryTreeMaximumPathSum {

    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        depthFirstSearch(root)
        return maxSum
    }

    fun depthFirstSearch(node: TreeNode?): Int {
        if (node == null) return 0

        val leftGain = maxOf(depthFirstSearch(node.left), 0)
        val rightGain = maxOf(depthFirstSearch(node.right), 0)

        val pathSum = leftGain + rightGain + node.`val`
        maxSum = maxOf(maxSum, pathSum)

        return node.`val` + maxOf(leftGain, rightGain)
    }
}