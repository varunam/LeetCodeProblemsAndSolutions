fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0)
    )

    println(shortestPathBinaryMatrix(grid))
}

private fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val n = grid.size
    if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1

    val directions = arrayOf(
        intArrayOf(1, 0), intArrayOf(0, 1),
        intArrayOf(-1, 0), intArrayOf(0, -1),
        intArrayOf(1, -1), intArrayOf(-1, 1),
        intArrayOf(1, 1), intArrayOf(-1, -1)
    )

    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(0, 0, 1)) // r, c, size
    grid[0][0] = 1 // reset the visited node.

    while (queue.isNotEmpty()) {
        val (r, c, size) = queue.removeFirst()
        if (r == n - 1 && c == n - 1) {
            return size
        }

        for (d in directions) {
            val dr = r + d[0]
            val dc = c + d[1]

            if (dr in 0 until n && dc in 0 until n && grid[dr][dc] == 0) {
                queue.add(Triple(dr, dc, size + 1))
                grid[dr][dc]=1
            }
        }
    }

    return -1
}
