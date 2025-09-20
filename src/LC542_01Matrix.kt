fun main() {
    val input = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1)
    )

    val result = updateMatrix(input)
    for (ints in result) {
        printList(ints.toList())
        println()
    }
}

fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty()) return matrix

    val rows = matrix.size
    val cols = matrix[0].size

    val queue = ArrayDeque<Pair<Int, Int>>()
    val dist = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (matrix[r][c] == 0) {
                dist[r][c] = 0
                queue.add(Pair(r, c))
            }
        }
    }

    val directions = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, -1),
        intArrayOf(1, 0), intArrayOf(-1, 0)
    )

    while (queue.isNotEmpty()) {
        val (r, c) = queue.removeFirst()
        for (dir in directions) {
            val dr = r + dir[0]
            val dc = c + dir[1]

            if (dr in 0 until rows && dc in 0 until cols && dist[dr][dc] > dist[r][c] + 1) {
                dist[dr][dc] = dist[r][c] + 1
                queue.add(Pair(dr, dc))
            }
        }
    }

    return dist
}