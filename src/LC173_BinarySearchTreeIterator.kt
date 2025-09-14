fun main() {
    val tree = createBST(listOf(7, 3, 15, 9, 20))
    printTree(tree)

    val iterator = BSTIterator(tree)
    printDivider()
    printWithDivider("Designed Iterator")
    printDivider()
    println(iterator.next())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
}

class BSTIterator(root: TreeNode?) {

    private val stack = ArrayDeque<TreeNode>()

    init {
        pushLeft(root)
    }

    private fun pushLeft(node: TreeNode?) {
        var curr = node
        while (curr != null) {
            stack.addFirst(curr)
            curr = curr.left
        }
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    fun next(): Int {
        val node = stack.removeFirst()
        if (node.right != null) pushLeft(node.right)
        return node.`val`
    }

}