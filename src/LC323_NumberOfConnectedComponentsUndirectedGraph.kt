/**
 * Problem: Number of Connected Components in an Undirected Graph (LeetCode 323)
 *
 * You are given n nodes labeled from 0 to n - 1 and an array of undirected edges
 * (where each edge is a pair [u, v]).
 *
 * Return the number of connected components in the graph.
 *
 * Example:
 * ----------
 * Input:
 *   n = 5
 *   edges = [[0,1],[1,2],[3,4]]
 *
 * Graph visualization:
 *   0 - 1 - 2     3 - 4
 *
 * Output: 2
 *
 * Explanation:
 *   The graph has two connected components:
 *   - Component 1: {0,1,2}
 *   - Component 2: {3,4}
 *
 * Approach:
 * ----------
 * 1. Build an adjacency list for all nodes (size n).
 * 2. Maintain a visited array.
 * 3. Iterate through all nodes:
 *      - If a node has not been visited, start DFS/BFS from it.
 *      - Mark all reachable nodes as visited.
 *      - Increment component count.
 *
 * Complexity Analysis:
 * --------------------
 * - Time Complexity: O(V + E)
 *   - Each vertex visited once, each edge traversed once.
 * - Space Complexity: O(V + E)
 *   - Adjacency list + visited array + recursion/queue.
 *
 * Related Problems:
 * -----------------
 * - LC 200: Number of Islands (same idea on a grid)
 * - LC 261: Graph Valid Tree
 * - LC 684: Redundant Connection
 */

fun main() {
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )

    println(numberOfConnectedComponents(n, edges))
}

private fun numberOfConnectedComponents(n: Int, edges: Array<IntArray>): Int {
    val adjList = Array(n) { mutableListOf<Int>() }
    for (e in edges) {
        adjList[e[0]].add(e[1])
        adjList[e[1]].add(e[0])
    }
    val visited = BooleanArray(n)
    var count = 0

    for (i in 0 until n) {
        if (visited[i].not()) {
            count++
            dfs(i, adjList, visited)
        }
    }

    return count
}

private fun dfs(node: Int, adjList: Array<MutableList<Int>>, visited: BooleanArray) {
    if (visited[node]) return
    visited[node] = true
    for (nei in adjList[node]) {
        dfs(nei, adjList, visited)
    }
}