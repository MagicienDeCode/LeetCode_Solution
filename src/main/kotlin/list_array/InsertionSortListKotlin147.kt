package list_array

class InsertionSortListKotlin147 {
    fun insertionSortList(head: ListNode?): ListNode? {
        val preNewHead = ListNode()
        var current = head
        var pre: ListNode
        var next: ListNode?
        while (current != null) {
            // each time reset pre,next
            pre = preNewHead
            next = preNewHead.next

            // find the insert position
            while (next != null) {
                if (current.`val` < next.`val`) {
                    break
                }
                pre = pre.next
                next = next.next
            }

            // mark the next
            val nextToBeInsert = current.next

            // insert
            pre.next = current
            current.next = next
            current = nextToBeInsert
        }
        return preNewHead.next
    }
}