fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '0', '0', '0', '0'),
        charArrayOf('0', '1', '0', '1', '0')
    )
    val numIslands = numIslandsBfs(grid)
    println(numIslands)
}

private fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == '1') {
                count++
                println("Incremented Counter. Initiating dfs at ($i,$j)")
                dfs(grid, i, j)
            }
        }
    }

    return count
}

private fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
    if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size || grid[r][c] == '0') {
        println("Returning for ($r, $c) in grid")
        return
    }

    grid[r][c] = '0'

    dfs(grid, r + 1, c)
    dfs(grid, r - 1, c)
    dfs(grid, r, c + 1)
    dfs(grid, r, c - 1)
}

private fun numIslandsBfs(grid: Array<CharArray>): Int {
    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == '1') {
                count++
                bfs(grid, i, j)
            }
        }
    }
    return count
}

private fun bfs(grid: Array<CharArray>, r: Int, c: Int) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    grid[r][c] = '0'
    queue.add(Pair(r, c))
    val directions = listOf(
        Pair(1, 0),  // down
        Pair(-1, 0), // up
        Pair(0, 1),  // right
        Pair(0, -1)  // left
    )
    val rows = grid.size
    val cols = grid[0].size

    while (queue.isNotEmpty()) {
        val (ar, ac) = queue.removeFirst()
        for ((br, bc) in directions) {
            val cr = br + ar
            val cc = bc + ac

            if (cr in 0 until rows && cc in 0 until cols && grid[cr][cc] == '1') {
                grid[cr][cc] = '0'
                queue.add(Pair(cr, cc))
            }
        }
    }
}