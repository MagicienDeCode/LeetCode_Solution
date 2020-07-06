package string_integer;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            ++digits[digits.length - 1];
            return digits;
        }
        int next = 1;
        digits[digits.length - 1] = 0;
        for (int index = digits.length - 2; index >= 0; index--) {
            if (next == 1) {
                if (digits[index] == 9) {
                    digits[index] = 0;
                    next = 1;
                } else {
                    ++digits[index];
                    next = 0;
                }
            }
        }
        if (next == 1 && digits[0] == 0) {
            final int[] result = new int[digits.length + 1];
            result[0] = 0;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }
}
