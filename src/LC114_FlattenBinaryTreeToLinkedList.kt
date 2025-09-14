/**
 * Explanation Video: https://www.youtube.com/watch?v=rKnD7rLT0lI
 */
fun main() {
    val tree = createTree(listOf(1, 2, 5, 3, 4, null, 6))
    printTree(tree)
    printDivider()
    printWithDivider("Flattening the tree")
    printDivider()
    flattenBinaryTree(tree)
    printTree(tree)
}

private fun flattenBinaryTree(root: TreeNode?) {
    if (root == null) return
    flattenBinaryTree(root.left)
    flattenBinaryTree(root.right)

    val temp = root.right
    root.right = root.left
    root.left = null

    var curr = root
    while (curr?.right != null) {
        curr = curr.right
    }
    curr?.right = temp
}