fun main() {
    val bst = createBST(listOf(1, 2, 3, 4, 2))
    printTree(bst)
    println(searchBSTIterative(bst, 4)?.`val`)
}

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null || root.`val` == `val`) return root
    return if (root.`val` > `val`) {
        searchBST(root.left, `val`)
    } else {
        searchBST(root.right, `val`)
    }
}

fun searchBSTIterative(root: TreeNode?, `val`: Int): TreeNode? {
    var current = root
    while (current != null) {
        if (current.`val` == `val`) {
            return current
        }
        current = if (`val` < current.`val`) {
            current.left
        } else {
            current.right
        }
    }
    return null
}
