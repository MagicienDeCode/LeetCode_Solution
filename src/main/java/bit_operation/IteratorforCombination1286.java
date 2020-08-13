package bit_operation;

// Copy from exlevan
public class IteratorforCombination1286 {

    private int bit;
    private final int length;
    private final char[] chars;

    public IteratorforCombination1286(String characters, int combinationLength) {
        length = combinationLength;
        chars = characters.toCharArray();
        bit = (1 << characters.length()) - (1 << (characters.length() - length));
    }

    public String next() {
        final char[] result = new char[length];
        int b = bit;
        int indexChar = chars.length - 1;
        int indexResult = length - 1;
        while (indexResult >= 0) {
            if ((b & 1) == 1) {
                result[indexResult] = chars[indexChar];
                --indexResult;
            }
            b >>= 1;
            --indexChar;
        }

        // Calculate the next combination
        // To get the next combination, we're performing the following steps
        //   (for example, let's assume we're starting with 01100011):
        // 1. Remove all trailing 1's from the end of the bitmask (by doing bits & (bits + 1)
        //    01100011 -> 01100000
        // 2. Take the last 1 that is followed by 0s, and shift it one position to the right,
        //    filling the remaining bits with 1's. That's can be done by decrementing the value
        //    01100000 -> 0101111
        // 3. Remove some 1s from the end to restore total number of 1s in the mask. This
        //    can be done by calculating the number of different bits between the current and
        //    starting bitmask, and shifting number to the right, then to the left by that value.
        //    0101111 -> 0101110

        final int b1 = (bit & (bit + 1)) - 1;
        final int shift = Integer.bitCount(bit ^ b1) - 2;
        bit = b1 >> shift << shift;

        return new String(result);
    }

    public boolean hasNext() {
        return bit > 0;
    }
}
