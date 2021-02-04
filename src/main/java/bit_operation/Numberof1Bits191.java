package bit_operation;

public class Numberof1Bits191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                ++result;
            }
            n >>= 1;
        }
        return result;
    }
}
