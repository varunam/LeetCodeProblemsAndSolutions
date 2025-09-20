fun main() {
    val heights = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4)
    )

    val result = pacificAtlantic(heights)
    result.forEach {
        printList(it)
        println()
    }
}

private fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    if (heights.isEmpty()) return emptyList()

    val rows = heights.size
    val cols = heights[0].size

    val pacific = Array(rows) { BooleanArray(cols) }
    val atlantic = Array(rows) { BooleanArray(cols) }

    val pacQueue = ArrayDeque<Pair<Int, Int>>()
    val atlQueue = ArrayDeque<Pair<Int, Int>>()

    for (c in 0 until cols) {
        pacQueue.add(Pair(0, c))
        pacific[0][c] = true
    }

    for (r in 0 until rows) {
        pacQueue.add(Pair(r, 0))
        pacific[r][0] = true
    }

    for (c in 0 until cols) {
        atlQueue.add(Pair(rows - 1, c))
        atlantic[rows - 1][c] = true
    }

    for (r in 0 until rows) {
        atlQueue.add(Pair(r, cols - 1))
        atlantic[r][cols - 1] = true
    }

    bfs(pacQueue, pacific, heights)
    bfs(atlQueue, atlantic, heights)

    val result = mutableListOf<List<Int>>()
    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (pacific[r][c] && atlantic[r][c]) {
                result.add(listOf(r, c))
            }
        }
    }

    return result
}

private fun bfs(queue: ArrayDeque<Pair<Int, Int>>, visited: Array<BooleanArray>, heights: Array<IntArray>) {
    val rows = heights.size
    val cols = heights[0].size

    val directions = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, -1),
        intArrayOf(1, 0), intArrayOf(-1, 0)
    )

    while (queue.isNotEmpty()) {
        val (r, c) = queue.removeFirst()
        for (dir in directions) {
            val dr = r + dir[0]
            val dc = c + dir[1]
            if (dr in 0 until rows && dc in 0 until cols && visited[dr][dc].not() && heights[dr][dc] >= heights[r][c]) {
                queue.add(Pair(dr, dc))
                visited[dr][dc] = true
            }
        }
    }
}