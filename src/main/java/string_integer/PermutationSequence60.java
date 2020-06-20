package string_integer;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence60 {

    private static final int[] permutation = new int[10];

    static {
        permutation[0] = 1;
        for (int index = 1; index < permutation.length; index++) {
            permutation[index] = permutation[index - 1] * index;
        }
    }

    public String getPermutation(int n, int k) {
        final StringBuilder result = new StringBuilder();
        int current = k - 1;
        final List<Integer> numbers = new ArrayList<>();
        for (int index = 1; index <= n; index++) {
            numbers.add(index);
        }
        for (int index = n; index > 0; index--) {
            final int p = permutation[index - 1];
            result.append(numbers.get(current / p));
            numbers.remove(current / p);
            current %= p;
        }
        return result.toString();
    }
}
