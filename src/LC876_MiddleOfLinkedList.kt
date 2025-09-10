import kotlin.random.Random

fun main() {
    var head = createLinkedList(listOf(1, 2, 3, 4, 5))
    printLinkedList(head)
    var result = getMiddleOfLinkedList(head)
    println("Result: ${result?.`val`}")

    println("--- Creating New Linked List ---")
    head = createLinkedList(listOf(1, 2, 3, 4, 5, 6))
    printLinkedList(head)
    result = getMiddleOfLinkedList(head)
    println("Result: ${result?.`val`}")
}

fun getMiddleOfLinkedList(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}
