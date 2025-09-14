fun main() {
    val tree = createTree(listOf(10,5,-3,3,2,null,11,3,-2,null,1))
    val targetSum = 8
    println(pathSum(tree, targetSum))
}

private fun pathSum(root: TreeNode?, targetSum: Int): Int {
    val hashMap = HashMap<Long, Int>()
    hashMap[0L] = 1
    return dfs(root, 0L, targetSum.toLong(), hashMap)
}

private fun dfs(node: TreeNode?, currentSum: Long, targetSum: Long, hashMap: HashMap<Long, Int>): Int {
    if (node == null) return 0

    var newSum = currentSum + node.`val`
    var count = hashMap.getOrDefault(newSum - targetSum, 0)

    hashMap[newSum] = hashMap.getOrDefault(newSum - targetSum, 0) + 1

    count += dfs(node.left, newSum, targetSum, hashMap)
    count += dfs(node.right, newSum, targetSum, hashMap)

    hashMap[newSum] = hashMap[newSum]!! - 1

    return count
}