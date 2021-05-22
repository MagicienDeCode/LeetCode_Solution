package easy_easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray961 {
    public int repeatedNTimes(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            } else {
                set.add(n);
            }
        }
        return -1;
    }
}
