fun main() {
    val n = 2
    val edges = arrayListOf(intArrayOf(0, 1), intArrayOf(1, 0))
    println(canFinishBfs(n, arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
}

private fun canFinish(n: Int, edges: ArrayList<IntArray>): Boolean {
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
    if (state[n] == 1) return false // found loop
    if (state[n] == 2) return true // completed traversal
    state[n] = 1

    for (nei in adjList[n]) {
        if (!dfs(nei, adjList, state)) {
            return false
        }
    }
    state[n] = 2
    return true
}

private fun canFinishBfs(totalCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val courseGraph = Array(totalCourses) { mutableListOf<Int>() }
    val indegree = IntArray(totalCourses)

    for (relation in prerequisites) {
        val course = relation[0]
        val prerequisite = relation[1]
        courseGraph[prerequisite].add(course)
        indegree[course]++
    }

    val availableCourses = ArrayDeque<Int>()
    for (i in 0 until totalCourses) {
        if (indegree[i] == 0) {
            availableCourses.add(i)
        }
    }

    var completedCourse = 0
    while (availableCourses.isNotEmpty()) {
        val currentCourse = availableCourses.removeFirst()
        completedCourse++
        for (nextCourse in courseGraph[currentCourse]) {
            indegree[nextCourse]--
            if (indegree[nextCourse] == 0) {
                availableCourses.add(nextCourse)
            }
        }
    }

    return completedCourse == totalCourses
}