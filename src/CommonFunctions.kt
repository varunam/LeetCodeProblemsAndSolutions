import kotlin.random.Random

fun createLinkedList(size: Int): ListNode? {
    val head = ListNode(1)
    var temp = head
    for (i in 0 until size) {
        val node = ListNode(Random.nextInt(100))
        temp.next = node
        temp = node
    }
    return head.next
}

fun createLinkedList(values: List<Int>): ListNode? {
    val head = ListNode(values[0])
    var temp = head
    for (i in 0 until values.size) {
        val node = ListNode(values[i])
        temp.next = node
        temp = node
    }
    return head.next
}

fun printLinkedList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun createTree(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    val root = TreeNode(values[0]!!)
    val queue: ArrayDeque<TreeNode> = ArrayDeque()
    queue.add(root)
    var i = 1

    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()

        // left child
        if (i < values.size && values[i] != null) {
            node.left = TreeNode(values[i]!!)
            queue.add(node.left!!)
        }
        i++

        // right child
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        i++
    }

    return root
}


fun printTree(root: TreeNode?) {
    if (root == null) return

    val height = getHeight(root)
    val maxWidth = (1 shl height) - 1 // total spaces

    val queue: ArrayDeque<TreeNode?> = ArrayDeque()
    queue.add(root)

    var level = 0
    while (level < height) {
        val levelSize = queue.size
        val spaces = (1 shl (height - level - 1)) - 1
        val between = (1 shl (height - level)) - 1

        // print nodes
        var line = ""
        for (i in 0 until levelSize) {
            val node = queue.removeFirst()
            line += " ".repeat(spaces)
            if (node == null) {
                line += " "
                queue.add(null)
                queue.add(null)
            } else {
                line += node.`val`.toString()
                queue.add(node.left)
                queue.add(node.right)
            }
            line += " ".repeat(between)
        }
        println(line)

        level++
    }
}

fun getHeight(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + maxOf(getHeight(root.left), getHeight(root.right))
}

fun printList(list: List<Int>) {
    list.forEach { print("$it ") }
}

fun createBST(values: List<Int>): TreeNode? {
    var root: TreeNode? = null
    for (v in values) {
        root = insertNodeToBST(root, v)
    }
    return root
}

fun insertNodeToBST(root: TreeNode?, value: Int): TreeNode? {
    if (root == null) return TreeNode(value)
    if (value < root.`val`) {
        root.left = insertNodeToBST(root.left, value)
    } else {
        root.right = insertNodeToBST(root.right, value)
    }
    return root
}