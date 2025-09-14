fun main() {
    val tree = createTree(listOf(3, 1, 4, null, null, 2))
    printTree(tree)
    printDivider()
    printWithDivider("Recovering BST")
    printDivider()
    BstRecoverer().recoverBst(tree)
    printTree(tree)
}

class BstRecoverer() {

    private var first: TreeNode? = null
    private var second: TreeNode? = null
    private var prev = TreeNode(Int.MIN_VALUE)

    fun recoverBst(root: TreeNode?) {
        inorder(root)
        val tmp = first!!.`val`
        first!!.`val` = second!!.`val`
        second!!.`val` = tmp
    }

    private fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        if (prev.`val` > root.`val`) {
            if (first == null) first = prev
            second = root
        }
        prev = root
        inorder(root.right)
    }

}