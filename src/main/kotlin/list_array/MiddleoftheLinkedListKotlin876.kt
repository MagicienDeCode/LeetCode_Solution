package list_array

class MiddleoftheLinkedListKotlin876 {
    fun middleNode(head: ListNode): ListNode? {
        var fast: ListNode? = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next.next
            slow = slow.next
        }
        return slow
    }
}