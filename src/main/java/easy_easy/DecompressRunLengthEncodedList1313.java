package easy_easy;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList1313 {
    public int[] decompressRLElist(int[] nums) {
        final List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            final int freq = nums[i];
            final int value = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                results.add(value);
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
