fun main() {
    val n = 2
    val edges = arrayListOf(intArrayOf(0, 1), intArrayOf(1, 0))
    println(canFinish(n, edges))
}

fun canFinish(n: Int, edges: ArrayList<IntArray>): Boolean {
    val adjList = Array(n) { mutableListOf<Int>() }
    for (e in edges) {
        adjList[e[1]].add(e[0])
    }

    val state = IntArray(n) { 0 }

    for (i in 0 until n) {
        if (state[i] == 0 && dfs(i, adjList, state).not()) {
            return false
        }
    }

    return true
}

private fun dfs(n: Int, adjList: Array<MutableList<Int>>, state: IntArray): Boolean {
    if (state[n] == 1) return false
    if (state[n] == 2) return true
    state[n] = 1

    for (nei in adjList[n]) {
        if (!dfs(nei, adjList, state)) {
            return false
        }
    }
    state[n] = 2
    return true
}