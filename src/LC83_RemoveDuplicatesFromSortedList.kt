fun main() {
    val head = createLinkedList(listOf(1, 1, 2, 2, 3, 4, 5, 5))
    printLinkedList(head)

    val result = removeDuplicates(head)
    printLinkedList(result)
}

fun removeDuplicates(head: ListNode?): ListNode? {
    var temp = head

    while (temp?.next != null) {
        if (temp.`val` == temp.next?.`val`) {
            temp.next = temp.next?.next
        } else {
            temp = temp.next
        }
    }

    return head
}