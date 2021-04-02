package list_array;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null) {
            slow = reverseList(slow);
        } else {
            slow = reverseList(slow.next);
        }
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode before = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = before;
            before = current;
            current = next;
        }
        return before;
    }
}
