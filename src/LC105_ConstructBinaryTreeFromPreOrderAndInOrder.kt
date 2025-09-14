fun main() {
    val preOrder = intArrayOf(3, 9, 20, 15, 7)
    val inOrder = intArrayOf(9, 3, 15, 20, 7)

    println("PreOrder: $preOrder")
    println("InOrder: $inOrder")
    printWithDivider("Creating Tree")
    val tree = TreeBuilder().buildTree(preOrder, inOrder)
    printTree(tree)
}

private class TreeBuilder() {

    private lateinit var inorderIndex: Map<Int, Int>
    private var preorderIndex = 0

    fun buildTree(preOrder: IntArray, inOrder: IntArray): TreeNode? {
        inorderIndex = inOrder.withIndex().associate { it.value to it.index }
        preorderIndex = 0
        return constructTree(preOrder, 0, inOrder.size - 1)
    }

    private fun constructTree(preOrder: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val rootVal = preOrder[preorderIndex]
        preorderIndex++

        val root = TreeNode(rootVal)
        val index = inorderIndex[rootVal]!!

        root.left = constructTree(preOrder, left, index - 1)
        root.right = constructTree(preOrder, index + 1, right)

        return root
    }
}
