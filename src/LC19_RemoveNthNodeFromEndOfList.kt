fun main() {
    val head = createLinkedList(listOf(1, 2, 3, 4, 5))
    printLinkedList(head)

    var result = removeNthNodeFromEndOfList(head, 4)
    printLinkedList(result)
}

fun removeNthNodeFromEndOfList(head: ListNode?, n: Int): ListNode {
    var dummy = ListNode(-1)
    dummy.next = head
    var slow = dummy
    var fast = dummy

    repeat(n + 1) {
        fast = fast.next!!
    }

    while (fast.next != null) {
        slow = slow.next!!
        fast = fast.next!!
    }

    slow.next = slow.next?.next
    return dummy.next!!
}