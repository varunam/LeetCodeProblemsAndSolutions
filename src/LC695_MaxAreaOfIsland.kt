import kotlin.math.max

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    val grid2 = arrayOf(intArrayOf(1))
    println(calculateMaxAreaDfs(grid))
}

private fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    val rows = grid.size
    val cols = grid[0].size

    var maxArea = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == 1) {
                maxArea = maxOf(maxArea, 1)
                val area = calculateMaxArea(grid, r, c)
                maxArea = maxOf(maxArea, area)
            }
        }
    }

    return maxArea
}

private fun calculateMaxArea(grid: Array<IntArray>, r: Int, c: Int): Int {
    val rows = grid.size
    val cols = grid[0].size

    val directions = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, -1),
        intArrayOf(1, 0), intArrayOf(-1, 0)
    )

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(r to c)

    var area = 0

    while (queue.isNotEmpty()) {
        val (row, col) = queue.removeFirst()
        for (dir in directions) {
            val nr = row + dir[0]
            val nc = col + dir[1]

            if (nr in 0 until rows && nc in 0 until cols && grid[nr][nc] == 1) {
                area++
                grid[nr][nc] = 0
                queue.add(nr to nc)
            }
        }
    }

    return area
}

private fun calculateMaxAreaDfs(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size

    var maxArea = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == 1) {
                maxArea = maxOf(maxArea, dfs(grid, r, c))
            }
        }
    }
    return maxArea
}

private fun dfs(grid: Array<IntArray>, r: Int, c: Int): Int {
    if (r !in 0 until grid.size || c !in 0 until grid[0].size || grid[r][c] == 0) {
        return 0
    }

    grid[r][c] = 0
    var area = 1

    area += dfs(grid, r + 1, c)
    area += dfs(grid, r - 1, c)
    area += dfs(grid, r, c + 1)
    area += dfs(grid, r, c - 1)

    return area
}