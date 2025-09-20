/**
 * Video Explanation: https://www.youtube.com/watch?v=mQeF6bN8hMk
 */
fun main() {
    val adjList = arrayOf(
        intArrayOf(2, 4),
        intArrayOf(1, 3),
        intArrayOf(2, 4),
        intArrayOf(1, 3)
    )

    val graph = createGraph(adjList)
    printGraph(graph)

    printDivider()
    printWithDivider("Cloning Graph")
    printDivider()

    val clonedNode = cloneGraphBfs(graph)
    printGraph(clonedNode)
}

private fun cloneGraph(node: GraphNode?): GraphNode? {
    if (node == null) return null
    val map = hashMapOf<GraphNode, GraphNode>()
    return dfs(node, map)
}

private fun dfs(node: GraphNode, map: HashMap<GraphNode, GraphNode>): GraphNode {
    if (map.containsKey(node)) return map[node]!!

    val newNode = GraphNode(node.`val`)
    map[node] = newNode

    for (nei in node.neighbors) {
        newNode.neighbors.add(dfs(nei, map))
    }

    return newNode
}

private fun cloneGraphBfs(node: GraphNode?): GraphNode? {
    if(node == null) return null

    val hashMap = hashMapOf<GraphNode, GraphNode>()
    val queue = ArrayDeque<GraphNode>()

    val newNode = GraphNode(node.`val`)
    hashMap[node] = newNode
    queue.add(node)

    while(queue.isNotEmpty()) {
        val current = queue.removeFirst()

        for(nei in current.neighbors) {
            if(hashMap.containsKey(nei).not()) {
                hashMap[nei] = GraphNode(nei.`val`)
                queue.add(nei)
            }
            hashMap[current]!!.neighbors.add(hashMap[nei]!!)
        }
    }
    return newNode
}

