package sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        final int[] resultArray = new int[nums.length - k + 1];
        // store index of nums
        final Deque<Integer> deque = new LinkedList<>();
        // deque:   offerFirst ==>           <== offerLast
        //          <== pollFirst            pollLast ==>
        for (int i = 0; i < nums.length; i++) {
            // if deque.first is left of window, remove it
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // remove from last if last < current
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // add current
            deque.offerLast(i);
            if ((i + 1) >= k) {
                resultArray[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return resultArray;
    }
}
