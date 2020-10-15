package list_array

class RotateListKotlin61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (k == 0 || head == null) {
            return head
        }
        var current: ListNode = head
        var count = 1
        while (current.next != null) {
            current = current.next
            ++count
        }
        val moveRight = k % count
        var move = count - moveRight - 1
        var split: ListNode = head
        while (move != 0) {
            split = split.next
            --move
        }
        current.next = head
        val result = split.next
        split.next = null
        return result
    }
}