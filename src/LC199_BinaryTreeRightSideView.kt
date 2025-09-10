fun main() {
    val tree = createTree(listOf(1, 2, 3, 4, null, null, null, 5))
    printTree(tree)
    val result = getRightSideViewDFS(tree)
    println("Right Side View: $result")
}

private fun getRightSideView(node: TreeNode?): List<Int> {
    if (node == null) return emptyList()
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(node)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.removeFirst()
            if (i == size - 1) {
                result.add(node.`val`)
            }
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }
    return result
}

private fun getRightSideViewDFS(node: TreeNode?): List<Int> {
    if (node == null) return emptyList()
    val result = mutableListOf<Int>()
    depthFirstSearch(node, 0, result)
    return result
}

private fun depthFirstSearch(node: TreeNode?, depth: Int, result: MutableList<Int>) {
    if (node == null) return
    if (depth == result.size) {
        result.add(node.`val`)
    }
    depthFirstSearch(node.right, depth + 1, result)
    depthFirstSearch(node.left, depth + 1, result)
}