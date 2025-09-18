fun main() {
    val n = 4
    val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2))
    printList(courseSchedule(n, prerequisites).toList())
}

fun courseSchedule(n: Int, edges: Array<IntArray>): IntArray {
    val adjList = Array(n) { mutableListOf<Int>() }
    for (e in edges) {
        adjList[e[1]].add(e[0])
    }

    val state = IntArray(n) { 0 }
    val result = mutableListOf<Int>()

    for (i in 0 until n) {
        if (state[i] == 0) {
            dfs(i, state, adjList, result)
        }
    }

    return result.reversed().toIntArray()
}

private fun dfs(n: Int, state: IntArray, adjList: Array<MutableList<Int>>, result: MutableList<Int>) {
    state[n] = 1
    for (nei in adjList[n]) {
        if (state[nei] == 0) {
            dfs(nei, state, adjList, result)
        } else if (state[nei] == 1) {
            return
        }
    }
    state[n] = 2
    result.add(n)
}