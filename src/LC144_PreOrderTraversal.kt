import java.util.Stack

fun main() {
    val tree = createTree(listOf(1, 2, 3, 4, 5, 6, 7))
    printTree(tree)
    val result = preOrderTraversal(tree)
    printList(result)
}

private fun preOrderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    depthFirstSearch(result, root)
    return result
}

private fun depthFirstSearch(result: MutableList<Int>, root: TreeNode?) {
    if (root == null) return
    result.add(root.`val`)
    depthFirstSearch(result, root.left)
    depthFirstSearch(result, root.right)
}

private fun depthFirstSearchStack(root: TreeNode?): List<Int> {
    var current = root
    val result = mutableListOf<Int>()
    if (root == null) return result
    val stack = Stack<TreeNode>()
    stack.push(current)
    while (stack.isNotEmpty()) {
        current = stack.pop()
        result.add(current.`val`)

        current.left?.let { stack.push(it) }
        current.right?.let { stack.push(it) }
    }

    return result
}