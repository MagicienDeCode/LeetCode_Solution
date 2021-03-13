package list_array;

public class IntersectionofTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) return headA;
        ListNode first = headA;
        ListNode second = headB;
        while (true) {
            first = (first == null) ? headB : first.next;
            second = (second == null) ? headA : second.next;
            if (first == second) return first;
        }
    }

    public static void main(String[] args) {
        final IntersectionofTwoLinkedLists160 java = new IntersectionofTwoLinkedLists160();
        /*
        final ListNode test2 = new ListNode(2);
        final ListNode test6 = new ListNode(6);
        final ListNode test4 = new ListNode(4);
        test2.next = test6;
        test6.next = test4;
        final ListNode test1 = new ListNode(1);
        final ListNode test5 = new ListNode(5);
        test1.next = test5;
        System.out.println(java.getIntersectionNode(test2,test1));
        */
        final ListNode node5 = new ListNode(5);
        final ListNode node6 = new ListNode(6);
        final ListNode node1 = new ListNode(1);
        final ListNode node8 = new ListNode(8);
        final ListNode node4 = new ListNode(4);
        final ListNode node5_2 = new ListNode(52);

        node5.next = node6;
        node6.next = node1;
        node1.next = node8;
        node8.next = node4;
        node4.next = node5_2;

        final ListNode node4_2 = new ListNode(42);
        final ListNode node1_2 = new ListNode(12);

        node4_2.next = node1_2;
        node1_2.next = node8;


        System.out.println(java.getIntersectionNode(node4_2, node5).val);
    }
}
