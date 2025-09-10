/**
 * 21. Merge Two Sorted Lists
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
fun main() {
    val one = ListNode(1)
    val two = ListNode(2)
    val four = ListNode(4)
    one.next = two
    two.next = four

    val one2 = ListNode(1)
    val two2 = ListNode(2)
    val five = ListNode(5)
    one2.next = two2
    two2.next = five

    var merged = mergeTwoLists(one, one2)
    while (merged?.next != null) {
        println(merged.`val`)
        merged = merged.next
    }
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val newNode = ListNode(0)
    var temp = newNode
    var p1 = list1
    var p2 = list2

    while (p1 != null && p2 != null) {
        if (p1.`val` <= p2.`val`) {
            temp.next = p1
            p1 = p1.next
        } else {
            temp.next = p2
            p2 = p2.next
        }
        temp = temp.next!!
    }

    if (p1 != null) {
        temp.next = p1
    }
    if (p2 != null) {
        temp.next = p2
    }

    return newNode.next
}

fun mergeTwoListsRecursive(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }

    if (list1.`val` <= list2.`val`) {
        list1.next = mergeTwoListsRecursive(list1, list2)
        return list1
    } else {
        list2.next = mergeTwoListsRecursive(list2, list1)
        return list2
    }
}