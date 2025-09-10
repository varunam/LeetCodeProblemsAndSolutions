fun main() {
    val tree = createTree(listOf(1, 2, 2, 4, 5, 5, 4))
    println(isSymmetric(tree))
}

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return isMirror(root.left, root.right)
}

private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    return (left.`val` == right.`val` && isMirror(left.left, right.right) && isMirror(left.right, right.left))
}