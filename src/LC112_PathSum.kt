fun main() {
    val tree = createTree(listOf(5,4,8,11,null,13,4,7,2,null,null,null,1))
    printTree(tree)
    println("hasPathSum? ${hasPathSum(tree, 22)}")
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    if (root.left == null && root.right == null) return targetSum == root.`val`

    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}