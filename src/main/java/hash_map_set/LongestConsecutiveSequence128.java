package hash_map_set;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        final Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int max = 1;
        int count;

        for (int n : nums) {
            count = 1;
            int plus = n + 1;
            while (set.contains(plus)) {
                set.remove(plus);
                ++count;
                ++plus;
            }
            int minus = n - 1;
            while (set.contains(minus)) {
                set.remove(minus);
                ++count;
                --minus;
            }
            max = Math.max(max, count);
        }

        return max;
    }
    /*
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int count;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count = 1;
                while (i < nums.length && nums[i] == nums[i - 1] + 1) {
                    i++;
                    ++count;
                    while (i < nums.length && nums[i] == nums[i - 1]) {
                        i++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
     */
    /*
    // Copy from Solution
        public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
     */
}
