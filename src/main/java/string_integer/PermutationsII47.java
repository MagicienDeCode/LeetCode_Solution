package string_integer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        permutate(nums, 0, results);
        return results;
    }

    private void permutate(int[] nums, int start, List<List<Integer>> results) {
        if (start == nums.length) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = start; i < nums.length; i++) {
                int j = i - 1;
                while (j >= start && nums[j] != nums[i]) {
                    --j;
                }
                if (j != start - 1) {
                    continue;
                }
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

    public static void main(String[] args) {
        final PermutationsII47 java = new PermutationsII47();
        // 112 121 211
        final List<List<Integer>> results = java.permuteUnique(new int[]{1, 1, 2});
        results.forEach(
                it -> {
                    it.forEach(System.out::print);
                    System.out.println();
                }
        );
    }
}
