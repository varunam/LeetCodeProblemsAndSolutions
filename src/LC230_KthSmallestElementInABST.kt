import java.time.chrono.JapaneseEra.values

fun main() {
    val bst = createBST(listOf(3, 1, 4, 2))
    printTree(bst)
    val finder = KthSmallestElementFinder()
    val kthSmallest = finder.kthSmallest(bst, 1)
    printDivider()
    printWithDivider("Kth Smallest")
    printDivider()
    println("Kth smallest: $kthSmallest")
}

private class KthSmallestElementFinder {

    private var count = 0
    private var result = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inorder(root, k)
        return result
    }

    private fun inorder(root: TreeNode?, k: Int) {
        if (root == null) return
        inorder(root.left, k)
        count++
        if (count == k) {
            result = root.`val`
            return
        }
        inorder(root.right, k)
    }

}