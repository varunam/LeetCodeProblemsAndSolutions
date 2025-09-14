/**
 * Video Explanation: https://www.youtube.com/watch?v=nHR8ytpzz7c
 */
fun main() {
    val tree = createTree(listOf(3, 4, 1, 0, 0, null, 5))
    printTree(tree)
    printDivider()
    printWithDivider("Calculating Rob Value")
    printDivider()
    println("Max Rob Value: ${rob(tree)}")
}

private fun rob(root: TreeNode?): Int {
    val (rob, notRob) = dfs(root)
    return maxOf(rob, notRob)
}

private fun dfs(node: TreeNode?): Pair<Int, Int> {
    if (node == null) return Pair(0, 0)

    val left = dfs(node.left)
    val right = dfs(node.right)

    val rob = node.`val` + left.second + right.second
    val notRob = maxOf(left.first, left.second) + maxOf(right.first, right.second)

    return Pair(rob, notRob)
}