package binary_search;

public class KokoEatingBananas875 {
    // wrong !! with usecase [2,2] h=2
    /*
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int p : piles) {
            sum += p;
        }
        int left = (int) (sum / h) +1;
        int right = (int) (sum / (h - piles.length + 1)) + 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isValidTarget(piles, h, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isValidTarget(piles, h, left)) {
            return left;
        }
        return right;
    }
    */
    // correct !!
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int p : piles) {
            sum += p;
        }
        int left = (int) (sum / h);
        left = left == 0 ? 1 : left;
        int right = (int) (sum / (h - piles.length + 1)) + 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isValidTarget(piles, h, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isValidTarget(piles, h, left)) {
            return left;
        }
        return right;
    }

    /*
    private boolean isValidTarget(int[] piles, int h, int target) {
        return Arrays.stream(piles).map(
                // i -> i / target + i % target == 0 ? 0 : 1
                i -> i / target + (i % target == 0 ? 0 : 1)
        ).sum() <= h;
    }
     */
    private boolean isValidTarget(int[] piles, int h, int target) {
        int count = 0;
        for (int p : piles) {
            count = count + p / target + (p % target == 0 ? 0 : 1);
        }
        return count <= h;
    }
}
