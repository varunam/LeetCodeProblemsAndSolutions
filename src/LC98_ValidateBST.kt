fun main() {
    val bst = createBST(listOf(2, 1, 3))
    println(validateBST(bst))
}

fun validateBST(root: TreeNode?): Boolean {
    if (root == null) return true
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

fun isValid(root: TreeNode?, min: Long, max: Long): Boolean {
    if (root == null) return true
    if (root.`val` <= min || root.`val` >= max) return false
    return isValid(root.left, min, root.`val`.toLong()) && isValid(root.right, root.`val`.toLong(), max)
}