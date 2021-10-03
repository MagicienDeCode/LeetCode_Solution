package list_array;

import java.util.ArrayList;
import java.util.List;

public class SplitLinkedListinParts725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        int plusOne = count % k;
        final int size = count / k;
        final ListNode[] results = new ListNode[k];
        current = head;
        ListNode pre = new ListNode(0);
        for (int i = 0; i < k; i++) {
            int index = 0;
            results[i] = current;
            if (current == null) {
                continue;
            }
            final int target = size + (plusOne-- > 0 ? 1 : 0);
            while (index != target) {
                pre = current;
                current = current.next;
                index++;
            }
            pre.next = null;
        }

        return results;
    }
}
