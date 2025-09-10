fun main() {
    val head = createTree(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 25, 26, 27))
    printTree(head)
    val result = maxDepth(head)
    println("Max Depth: $result")
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return 1 + maxOf(left, right)
}