package list_array

class SortListKotlin148 {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val mid = middleNode(head)
        val left = sortList(head)
        val right = sortList(mid)
        return mergeTwoLists(left, right)
    }

    fun mergeTwoLists(l1Val: ListNode?, l2Val: ListNode?): ListNode? {
        var l1 = l1Val
        var l2 = l2Val
        val beforeHead = ListNode()
        var current = beforeHead
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                current.next = l1
                l1 = l1.next
            } else {
                current.next = l2
                l2 = l2.next
            }
            current = current.next
        }
        while (l1 != null) {
            current.next = l1
            l1 = l1.next
            current = current.next
        }
        while (l2 != null) {
            current.next = l2
            l2 = l2.next
            current = current.next
        }
        return beforeHead.next
    }

    /*
    1 -> 2 -> 3 -> 4
    fast = 1, slow = null
    fast = 3, slow = 1
    fast = null, slow = 2
    result = 3
    2.next = null
     */
    fun middleNode(head: ListNode?): ListNode {
        var fast = head
        var slow: ListNode? = null
        while (fast?.next != null) {
            fast = fast.next.next
            slow = if (slow == null) head else slow.next
        }
        val result = slow!!.next
        slow.next = null
        return result
    }
}