fun main() {
    val tree = createTree(listOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1))
    printTree(tree)
    val serialized = serialize(tree)
    printWithDivider("Serializing")
    println(serialized)
    printWithDivider("Deserializing")
    val node = deserialize(serialized)
    printTree(node)
}

private fun serialize(root: TreeNode?): String {
    val stringBuilder = StringBuilder()
    depthFirstSearch(root, stringBuilder)
    return stringBuilder.toString()
}

private fun depthFirstSearch(node: TreeNode?, sb: StringBuilder) {
    if (node == null) {
        sb.append("null,")
        return
    }

    sb.append("${node.`val`},")
    depthFirstSearch(node.left, sb)
    depthFirstSearch(node.right, sb)
}

private fun deserialize(data: String): TreeNode? {
    val queue = ArrayDeque(data.split(','))
    return depthFirstSearch(queue)
}

private fun depthFirstSearch(queue: ArrayDeque<String>): TreeNode? {
    val value = queue.removeFirst()
    if (value == "null" || value.isEmpty()) return null
    val node = TreeNode(value.toInt())
    node.left = depthFirstSearch(queue)
    node.right = depthFirstSearch(queue)
    return node
}