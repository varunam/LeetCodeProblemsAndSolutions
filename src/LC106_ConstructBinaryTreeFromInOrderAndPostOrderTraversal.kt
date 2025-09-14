fun main() {
    val postOrder = intArrayOf(9,15,7,20,3)
    val inOrder = intArrayOf(9, 3, 15, 20, 7)

    println("PreOrder: ")
    printList(postOrder.toList())
    println("InOrder: ")
    printList(inOrder.toList())
    printWithDivider("Creating Tree")
    val tree = BinaryTreeBuilder().buildTree(inOrder, postOrder)
    printTree(tree)
}

private class BinaryTreeBuilder() {
    lateinit var inorderIndices: Map<Int, Int>
    var postorderIndex = 0

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        inorderIndices = inorder.withIndex().associate { it.value to it.index }
        postorderIndex = postorder.size - 1
        return createTree(postorder, 0, inorder.size - 1)
    }

    private fun createTree(postorder: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val rootVal = postorder[postorderIndex]
        postorderIndex--
        val root = TreeNode(rootVal)

        val index = inorderIndices[rootVal]!!

        root.right = createTree(postorder, index + 1, right)
        root.left = createTree(postorder, left, index - 1)

        return root
    }
}