fun main() {
    val n = 4
    val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2))
    printList(courseScheduleBfs(n, prerequisites).toList())
}

fun courseScheduleBfs(totalAvailableCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val courseGraph = Array(totalAvailableCourses) { mutableListOf<Int>() }
    val indegree = IntArray(totalAvailableCourses)
    for (relation in prerequisites) {
        val course = relation[0]
        val prerequisite = relation[1]
        courseGraph[prerequisite].add(course)
        indegree[relation[0]]++
    }

    val availableCourses = ArrayDeque<Int>()
    for (course in 0 until totalAvailableCourses) {
        if (indegree[course] == 0) {
            availableCourses.add(course)
        }
    }

    val orderOfCourseCompletion = mutableListOf<Int>()
    while (availableCourses.isNotEmpty()) {
        val curr = availableCourses.removeFirst()
        orderOfCourseCompletion.add(curr)

        for (nei in courseGraph[curr]) {
            indegree[nei]--
            if (indegree[nei] == 0) {
                availableCourses.add(nei)
            }
        }
    }

    return if(orderOfCourseCompletion.size == totalAvailableCourses) orderOfCourseCompletion.toIntArray() else intArrayOf()
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