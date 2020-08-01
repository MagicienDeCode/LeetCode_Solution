package top_interview_easy.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
