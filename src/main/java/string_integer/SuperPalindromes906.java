package string_integer;

public class SuperPalindromes906 {
    public int superpalindromesInRange(String left, String right) {
        final long l = Long.parseLong(left);
        final long r = Long.parseLong(right);
        final int magic = 1000000;
        int count = 0;
        for (int i = 1; i < magic; i++) {
            final StringBuilder sbOdd = new StringBuilder(Integer.toString(i));
            for (int j = sbOdd.length() - 2; j >= 0; --j) {
                sbOdd.append(sbOdd.charAt(j));
            }
            final StringBuilder sbEven = new StringBuilder(Integer.toString(i));
            for (int j = sbEven.length() - 1; j >= 0; --j) {
                sbEven.append(sbEven.charAt(j));
            }
            final long odd = Long.parseLong(sbOdd.toString());
            final long candidateOdd = odd * odd;
            final long even = Long.parseLong(sbEven.toString());
            final long candidateEven = even * even;
            if (candidateOdd <= r && candidateOdd >= l && isPalindrome(candidateOdd)) {
                ++count;
            }
            if (candidateEven <= r && candidateEven >= l && isPalindrome(candidateEven)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isPalindrome(long l) {
        return l == reverse(l);
    }

    private long reverse(long l) {
        long result = 0;
        while (l > 0) {
            result = result * 10 + l % 10;
            l /= 10;
        }
        return result;
    }
}
