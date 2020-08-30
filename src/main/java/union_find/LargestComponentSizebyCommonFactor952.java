package union_find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizebyCommonFactor952 {
    public int largestComponentSize(int[] nums) {
        final int maxUfIndex = Arrays.stream(nums).reduce(Math::max).orElse(-1);
        final int[] ufArray = new int[maxUfIndex + 1];
        for (int i = 0; i < ufArray.length; i++) {
            ufArray[i] = i;
        }
        for (int num : nums) {
            for (int factor = (int) Math.sqrt(num); factor >= 2; factor--) {
                if (num % factor == 0) {
                    ufArray[unionFind(ufArray, num)] = ufArray[unionFind(ufArray, factor)];
                    ufArray[unionFind(ufArray, num)] = ufArray[unionFind(ufArray, num / factor)];
                }
            }
        }
        final Map<Integer, Integer> resultMap = new HashMap<>();
        int result = 0;
        for (int r : nums) {
            final int uf = unionFind(ufArray, r);
            resultMap.put(uf, resultMap.getOrDefault(uf, 0) + 1);
            result = Math.max(result, resultMap.get(uf));
        }
        return result;
    }

    private int unionFind(int[] arr, int target) {
        return arr[target] == target ? target : (arr[target] = unionFind(arr, arr[target]));
    }

    /*
    Time Limit Exceeded
    private int unionFind(int[] arr, int target) {
        return arr[target] == target ? target : unionFind(arr, arr[target]);
    }
     */

    public static void main(String[] args) {
        final LargestComponentSizebyCommonFactor952 java =
                new LargestComponentSizebyCommonFactor952();
        // 8
        System.out.println(java.largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
        // 6
        System.out.println(java.largestComponentSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        // 2
        System.out.println(java.largestComponentSize(new int[]{20, 50, 9, 63}));
        // 4
        System.out.println(java.largestComponentSize(new int[]{4, 6, 15, 35}));
    }
}