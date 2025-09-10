fun main() {
    val tree = createTree(listOf(1, 2, 3, 4, 5, 6, 7))
    printTree(tree)
    val result = postOrderTraversal(tree)
    printList(result)
}

private fun postOrderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    depthFirstSearch(result, root)
    return result
}

private fun depthFirstSearch(result: MutableList<Int>, root: TreeNode?) {
    if(root == null) return
    depthFirstSearch(result, root.left)
    depthFirstSearch(result, root.right)
    result.add(root.`val`)
}