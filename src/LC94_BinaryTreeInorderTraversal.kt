import java.util.Stack

fun main() {
    val tree = createTree(listOf(1, 2, 2, 4, 5, 5, 4))
    val result = inOrderTraversalStack(tree)
    printList(result)
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    depthFirstSearch(result, root)
    return result
}

private fun depthFirstSearch(list: MutableList<Int>, root: TreeNode?) {
    if (root == null) return
    depthFirstSearch(list, root.left)
    list.add(root.`val`)
    depthFirstSearch(list, root.right)
}

fun inOrderTraversalStack(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()
    var current = root
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }
        current = stack.pop()
        result.add(current.`val`)

        current = current.right
    }

    return result
}