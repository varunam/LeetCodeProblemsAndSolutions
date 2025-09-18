/**
 *  https://www.youtube.com/playlist?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 *  I watched videos until DFS and wrote this code.
 */
fun main() {
    val adjList = listOf(
        listOf(1),     // neighbors of 0
        listOf(0, 2),  // neighbors of 1
        listOf(1, 3),  // neighbors of 2
        listOf(2)      // neighbors of 3
    )

    val result = dfs(4, adjList)
    printList(result)
}

fun bfs(n: Int, adjList: List<List<Int>>): MutableList<Int> {
    val bfs = mutableListOf<Int>()
    val visited = Array(n) { false }
    val queue = ArrayDeque<Int>()

    queue.add(0)
    visited[0] = true

    while (queue.isNotEmpty()) {
        val value = queue.removeFirst()
        bfs.add(value)

        for (i in adjList[value]) {
            if (!visited[i]) {
                visited[i] = true
                queue.add(i)
            }
        }
    }

    return bfs
}

fun dfs(n: Int, adjList: List<List<Int>>): MutableList<Int> {
    val visited = Array(n) { false }
    val result = mutableListOf<Int>()
    explore(0, visited, adjList, result)
    return result
}

fun explore(node: Int, visited: Array<Boolean>, adjList: List<List<Int>>, result: MutableList<Int>) {
    visited[node] = true
    result.add(node)
    for (nei in adjList[node]) {
        if (visited[nei].not()) {
            explore(nei, visited, adjList, result)
        }
    }
}