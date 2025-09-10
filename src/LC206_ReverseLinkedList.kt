/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

fun main() {
    val one = ListNode(1)
    val two = ListNode(2)
    val three = ListNode(3)
    val four = ListNode(4)
    val five = ListNode(5)
    one.next = two
    two.next = three
    three.next = four
    four.next = five
    five.next = null

    var curr: ListNode? = one
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }

    println("Reversing the linked list...")

    val reversedHead = reverseList(one)

    curr = reversedHead
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head

    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}

fun reverseListRecursive(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val newHead = reverseListRecursive(head.next)
    head.next?.next = newHead
    head.next = null
    return newHead
}