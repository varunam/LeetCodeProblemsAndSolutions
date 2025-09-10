fun main() {
    val tree = createTree(listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))
    printTree(tree)
    println(lowestCommonAncestor(tree, 5, 1)?.`val`)
}

/**
 * Solution Explanation - https://youtu.be/_-QHfMDde90?si=qv3yC8TFw9iwAB7B
 */
private fun lowestCommonAncestor(root: TreeNode?, p: Int, q: Int): TreeNode? {
    if (root == null || root.`val` == p || root.`val` == q) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    return when {
        left != null && right != null -> root
        left != null -> left
        else -> right
    }
}