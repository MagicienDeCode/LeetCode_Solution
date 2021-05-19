package easy_easy;

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        final List<Integer> results = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                results.add(i);
            }
        }
        return results;
    }

    private boolean isValid(final int i) {
        int current = i;
        while (current > 0) {
            final int temp = current % 10;
            if (temp == 0 || i % temp != 0) {
                return false;
            }
            current /= 10;
        }
        return true;
    }
}
