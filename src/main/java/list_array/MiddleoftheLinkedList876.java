package list_array;

public class MiddleoftheLinkedList876 {
    /*
     1 -> 2 -> 3 -> 4 -> 5
     fast = 1,slow = 1
     fast = 3,slow = 2
     fast = 5,slow = 3

     1 -> 2 -> 3 -> 4
     fast = 1,slow = 1
     fast = 3,slow = 2
     fast = null,slow = 3

     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
