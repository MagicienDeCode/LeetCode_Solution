package bit_operation;

import java.util.LinkedList;
import java.util.List;

public class GrayCode89 {
    public List<Integer> grayCode(int n) {
        final List<Integer> results = new LinkedList<>();
        final int end = 1 << n;
        for (int i = 0; i < end; i++) {
            results.add(i ^ i >> 1);
        }
        return results;
    }
}
