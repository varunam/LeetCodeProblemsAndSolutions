import java.util.ArrayList

fun main() {
    val tree = createTree(listOf(5,4,8,11,null,13,4,7,2,null,null,5,1))
    printTree(tree)
    println("Finding path sum arrays...")
    val result = pathSum(tree, 22)
    println(result)
}

private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()

    depthFirstSearch(root, targetSum, path, result)

    return result
}

private fun depthFirstSearch(root: TreeNode?, targetSum: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
    if (root == null) return

    path.add(root.`val`)

    if(root.left == null && root.right == null && root.`val` == targetSum) {
        result.add(ArrayList(path))
    } else {
        depthFirstSearch(root.left, targetSum - root.`val`, path, result)
        depthFirstSearch(root.right, targetSum - root.`val`, path, result)
    }

    path.removeAt(path.lastIndex)
}