package binary_search;

import java.util.Arrays;
import java.util.Random;

public class RandomPickwithBlacklist710 {
    private final int[] blacklist;
    private final Random random;
    private final int whiteSize;

    public RandomPickwithBlacklist710(int n, int[] blacklist) {
        this.blacklist = blacklist;
        this.random = new Random();
        this.whiteSize = n - blacklist.length;
        Arrays.sort(blacklist);
    }

    public int pick() {
        if (blacklist.length == 0) {
            return random.nextInt(whiteSize + blacklist.length);
        }
        final int r = random.nextInt(whiteSize);
        int left = 0;
        int right = blacklist.length - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (r + mid < blacklist[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (r + left < blacklist[left]) {
            return left + r;
        }
        if (r + right < blacklist[right]) {
            return right + r;
        }
        return r + right + 1;
    }
    /*
    private final int[] blacklist;
    private final Random random;
    private final int whiteSize;

    private final Map<Integer, Integer> map = new HashMap<>();

    public RandomPickwithBlacklist710(int n, int[] blacklist) {
        this.blacklist = blacklist;
        this.random = new Random();
        this.whiteSize = n - blacklist.length;
        Arrays.sort(blacklist);
        int current = n - 1;
        for (int b : blacklist) {
            if (b < whiteSize) {
                while (binarySearch(current)) {
                    --current;
                }
                map.put(b, current--);
            }
        }
    }

    public int pick() {
        final int r = random.nextInt(whiteSize);
        return map.getOrDefault(r, r);
    }

    private boolean binarySearch(int target) {
        if (blacklist.length == 0) {
            return false;
        }
        int left = 0;
        int right = blacklist.length - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (blacklist[mid] == target) {
                return true;
            } else if (blacklist[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return target == blacklist[left] || target == blacklist[right];
    }
     */
}
