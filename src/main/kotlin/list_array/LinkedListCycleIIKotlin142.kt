package list_array

class LinkedListCycleIIKotlin142 {
    fun detectCycle(head: ListNode?): ListNode? {
        // [1]
        if (head?.next == null) {
            return null
        }
        var slow: ListNode = head
        var fast = head
        while (fast?.next != null) {
            slow = slow.next
            fast = fast.next.next
            if (fast === slow) {
                break
            }
        }
        // [1,2]
        if (fast !== slow) {
            return null
        }
        slow = head
        while (slow !== fast) {
            slow = slow.next
            fast = fast!!.next
        }
        return slow
    }
}