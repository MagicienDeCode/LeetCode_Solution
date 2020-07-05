package string_integer;

public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 1; i <= 32; i++) {
            if ((xor & 1) == 1) {
                ++count;
            }
            xor >>= 1;
        }
        return count;
    }
}
