fun main() {
    val bst = createBST(listOf(4, 2, 7, 1, 3))
    println("---BEFORE---")
    printTree(bst)
    println("---AFTER---")
    printTree(insertIntoBSTIterative(bst, 5))
}

fun insertIntoBST(root: TreeNode?, value: Int): TreeNode {
    if (root == null) return TreeNode(value)
    if (value < root.`val`) {
        root.left = insertIntoBST(root.left, value)
    } else {
        root.right = insertIntoBST(root.right, value)
    }
    return root
}

fun insertIntoBSTIterative(root: TreeNode?, value: Int): TreeNode? {
    var current = root
    if (current == null) return TreeNode(value)
    while (true) {
        if (value < current!!.`val`) {
            if (current.left == null) {
                current.left = TreeNode(value)
                break
            } else {
                current = current.left
            }
        } else {
            if (current.right == null) {
                current.right = TreeNode(value)
                break
            } else {
                current = current.right
            }
        }
    }
    return root
}