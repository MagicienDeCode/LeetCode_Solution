package priority_queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII630 {
    /*
    Time complexity : O(nlogn). At most nn elements are added to the queuequeue. Adding each element is followed by heapification, which takes O\big(\log n\big)O(logn) time.
    Space complexity : O(n). The queuequeue containing the durations of the courses taken can have atmost nn elements
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int now = 0;
        for (int[] c : courses) {
            if (now + c[0] <= c[1]) {
                priorityQueue.offer(c[0]);
                now += c[0];
            } else if (!priorityQueue.isEmpty() && priorityQueue.peek() > c[0]) {
                now += c[0] - priorityQueue.poll();
                priorityQueue.offer(c[0]);
            }
        }
        return priorityQueue.size();
    }
}
