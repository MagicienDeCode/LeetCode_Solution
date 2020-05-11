package binary_search;

public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        if (isBadVersion(right)) {
            return right;
        }
        return -1;
    }

    boolean isBadVersion(int version) {
        return version > 3;
    }

    public static void main(String... args) {
        final FirstBadVersion278 solution = new FirstBadVersion278();
        System.out.println(solution.firstBadVersion(5));
    }
}
