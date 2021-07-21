package binary_search;

import java.util.ArrayList;
import java.util.List;

public class FindMedianfromDataStream295 {
    final List<Integer> lists = new ArrayList<>();

    public void addNum(int num) {
        if (lists.isEmpty()) {
            lists.add(num);
            return;
        }
        int left = 0;
        int right = lists.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (lists.get(mid) <= num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (lists.get(right) <= num) {
            lists.add(right + 1, num);
        } else if (lists.get(left) <= num) {
            lists.add(right, num);
        } else {
            lists.add(left, num);
        }
    }

    public double findMedian() {
        final int size = lists.size();
        return size % 2 == 0 ? (lists.get(size >> 1) + lists.get((size >> 1) - 1)) / 2.0 : lists.get(size >> 1);
    }
}
