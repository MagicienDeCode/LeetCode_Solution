package list_array

class MergeTwoSortedListsKotlin21 {
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
}