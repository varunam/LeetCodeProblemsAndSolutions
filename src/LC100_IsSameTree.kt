fun main() {
    val treeOne = createTree(listOf(1, 2, 3, 4, 5))
    printTree(treeOne)
    val treeTwo = createTree(listOf(1, 2, 3, 4, 3))
    printTree(treeTwo)
    println("Comparing if both the trees are same...")
    println("Same? ${isSameTree(treeOne, treeTwo)}")
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if(p == null && q == null) return true
    if(p == null || q == null) return false
    if (p.`val` != q.`val`) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}