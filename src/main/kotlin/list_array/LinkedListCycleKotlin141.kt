package list_array

class LinkedListCycleKotlin141 {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var slow: ListNode = head
        var fast = head
        while (fast?.next != null) {
            slow = slow.next
            fast = fast.next.next
            if (fast === slow) {
                return true
            }
        }
        return false
    }
}