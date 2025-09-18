fun main() {

}

fun hasCycle(n: Int, edges: ArrayList<IntArray>): Boolean {
    val adjList = Array(n) { mutableListOf<Int>() }
    for (e in edges) {
        adjList[e[0]].add(e[1])
        adjList[e[1]].add(e[0])
    }

    val visited = BooleanArray(n)

    for (i in 0 until n) {
        if (visited[i].not()) {
            if (dfs(node = i, parent = -1, visited = visited, adjList = adjList)) {
                return true
            }
        }
    }

    return false
}

private fun dfs(node: Int, parent: Int, visited: BooleanArray, adjList: Array<MutableList<Int>>): Boolean {
    visited[node] = true
    for (nei in adjList[node]) {
        if (visited[nei].not()) {
            if (dfs(nei, node, visited, adjList)) {
                return true
            }
        } else if (nei != parent) {
            return true
        }
    }
    return false
}