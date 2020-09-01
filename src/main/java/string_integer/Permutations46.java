package string_integer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> results = new LinkedList<>();
        permutate(nums, 0, results);
        return results;
    }

    private void permutate(int[] nums, int start, List<List<Integer>> results) {
        if (start == nums.length) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                permutate(nums, start + 1, results);
                swap(nums, i, start);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
