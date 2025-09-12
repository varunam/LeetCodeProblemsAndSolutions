fun main() {
    val tree = createTree(listOf(1, 2, 3, 4, 5))
    printTree(tree)
    val calculator = DiameterCalculator()
    println("DiameterOfBinaryTree: ${calculator.diameterOfBinaryTree(tree)}")

    val calculatorThroughHeight = DiameterCalculatorThroughHeight()
    println("DiameterOfBinaryTree: ${calculatorThroughHeight.diameterOfBinaryTree(tree)}")
}

class DiameterCalculator() {
    var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depthFirstSearch(root)
        return diameter
    }

    fun depthFirstSearch(node: TreeNode?): Int {
        if (node == null) return 0

        val leftDiameter = depthFirstSearch(node.left)
        val rightDiameter = depthFirstSearch(node.right)

        diameter = maxOf(diameter, leftDiameter + rightDiameter)

        return 1 + maxOf(leftDiameter, rightDiameter)
    }
}

/**
 * Video Guide: https://www.youtube.com/watch?v=aPyDPImR5UM
 */
class DiameterCalculatorThroughHeight() {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        val leftDiameter = diameterOfBinaryTree(root.left)
        val rightDiameter = diameterOfBinaryTree(root.right)
        val currentDiameter = calculateHeight(root.left) + calculateHeight(root.right)

        return maxOf(currentDiameter, maxOf(leftDiameter, rightDiameter))
    }

    fun calculateHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = calculateHeight(node.left)
        val rightHeight = calculateHeight(node.right)

        return maxOf(leftHeight, rightHeight) + 1
    }
}