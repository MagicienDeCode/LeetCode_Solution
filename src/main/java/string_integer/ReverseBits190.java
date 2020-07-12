package string_integer;

public class ReverseBits190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result = (result << 1) + 1;
            } else {
                result <<= 1;
            }
            n >>= 1;
        }
        return result;
    }
}
