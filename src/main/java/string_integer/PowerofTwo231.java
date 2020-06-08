package string_integer;

import java.util.HashSet;
import java.util.List;

public class PowerofTwo231 {
    private static final HashSet<Integer> resultSet =
            new HashSet<>(
                    List.of(
                            1,
                            2,
                            4,
                            8,
                            16,
                            32,
                            64,
                            128,
                            256,
                            512,
                            1024,
                            2048,
                            4096,
                            8192,
                            16384,
                            32768,
                            65536,
                            131072,
                            262144,
                            524288,
                            1048576,
                            2097152,
                            4194304,
                            8388608,
                            16777216,
                            33554432,
                            67108864,
                            134217728,
                            268435456,
                            536870912,
                            1073741824
                    )
            );

    public boolean isPowerOfTwo(int n) {
        return resultSet.contains(n);
    }
    /*
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        int current = 2;
        while (current < n && current <= 1073741823) {
            current = current << 1;
        }
        return current == n;
    }
     */
}
