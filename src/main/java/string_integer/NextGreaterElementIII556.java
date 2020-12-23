package string_integer;

public class NextGreaterElementIII556 {
    public int nextGreaterElement(int n) {
        final char[] chars = String.valueOf(n).toCharArray();
        if (chars.length == 2) {
            if (chars[0] >= chars[1]) {
                return -1;
            } else {
                swap(chars, 0, 1);
                return Integer.parseInt(new String(chars));
            }
        }
        // find the last position that [k-1] < [k]
        int k = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] < chars[i]) {
                k = i;
            }
        }
        if (k == 0) {
            return -1;
        }
        // from k to len-1, find the smallest element > [k-1]
        for (int i = chars.length - 1; i >= k; i--) {
            if (chars[i] > chars[k - 1]) {
                swap(chars, k - 1, i);
                break;
            }
        }
        // from k to len-1, it's in decreasing order, so we inverse it
        int left = k;
        int right = chars.length - 1;
        while (left <= right) {
            swap(chars, left++, right--);
        }
        final long result = Long.parseLong(new String(chars));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void swap(char[] chars, int i, int j) {
        if (i != j) {
            final char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {
        final NextGreaterElementIII556 java = new NextGreaterElementIII556();
        System.out.println(java.nextGreaterElement(120697420));
        System.out.println(java.nextGreaterElement(12));
        System.out.println(java.nextGreaterElement(21));
        System.out.println(java.nextGreaterElement(1));
    }
}
