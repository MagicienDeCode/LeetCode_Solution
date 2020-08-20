package list_array

class ReorderListKotlin143 {
    fun reorderList(head: ListNode?) {
        if (head?.next == null || head.next!!.next == null) {
            return
        }
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var first: ListNode = head
        var second: ListNode? = reverse(slow?.next)

        if (slow != null) {
            slow.next = null
        }
        // F 1 -> 2 -> 3
        // S 6 -> 5 -> 4
        /*
        f = 1
        s = 6

        1.next = 6
        6.next = 2

        s = 5
        f = 2
         */
        // F 1 -> 2 -> 3
        // S 6 -> 5 -> 4
        /*
        f = 1
        s = 6

        1.next = 6
        6.next = 2

        s = 5
        f = 2
         */
        while (second != null) {
            val firstNext = first.next
            val secondNext = second.next
            first.next = second
            second.next = firstNext
            second = secondNext
            if (firstNext != null) {
                first = firstNext
            }
        }
    }

    private fun reverse(root: ListNode?): ListNode? {
        // 5 -> 6 -> 7
        /*
        node = 5
        next = 6
        5.next = null
        prev = 5

        node = 6
        next = 7
        6.next = 5
        prev = 6

        node = 7
         */
        var node: ListNode? = root
        var prev: ListNode? = null
        var next: ListNode?
        while (node != null) {
            next = node.next
            node.next = prev
            prev = node
            node = next
        }
        return prev
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}