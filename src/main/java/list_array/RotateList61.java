package list_array;

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            ++count;
        }
        final int moveRight = k % count;
        int move = count - moveRight - 1;
        ListNode split = head;
        while (move != 0) {
            split = split.next;
            --move;
        }
        current.next = head;
        final ListNode result = split.next;
        split.next = null;
        return result;
    }
}
