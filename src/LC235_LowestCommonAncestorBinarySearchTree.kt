fun main() {

}

private fun lowestCommonAncestor(root: TreeNode?, p: Int, q: Int): TreeNode? {
    if(root == null) return null

    return if(p < root.`val` && q < root.`val`) {
        lowestCommonAncestor(root.left, p, q)
    } else if (p > root.`val` && q > root.`val`) {
        lowestCommonAncestor(root.right, p, q)
    } else {
        root
    }
}