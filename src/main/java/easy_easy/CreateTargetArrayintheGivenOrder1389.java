package easy_easy;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayintheGivenOrder1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        final List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            results.add(index[i], nums[i]);
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
