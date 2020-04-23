package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class FourSumII454 {
    public int fourSumCount(int[] numsA, int[] numsB, int[] numsC, int[] numsD) {
        if (numsA == null || numsA.length == 0) {
            return 0;
        }
        final Map<Integer, Integer> cCartesianDMap = new HashMap<>();
        for (int c : numsC) {
            for (int d : numsD) {
                cCartesianDMap.put(c + d, cCartesianDMap.computeIfAbsent(c + d, value -> 0) + 1);
            }
        }

        int result = 0;
        for (int a : numsA) {
            for (int b : numsB) {
                result += cCartesianDMap.getOrDefault(-a - b, 0);
            }
        }
        return result;
    }

    /*
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0) {
            return 0;
        }
        final int[] cCartesianD = Arrays.stream(C).flatMap(c ->
                Arrays.stream(D).map(d -> c + d)
        ).toArray();
        Arrays.sort(cCartesianD);

        int result = 0;
        for (int a : A) {
            for (int b : B) {
                final int firstIndex = searchFirstPosition(cCartesianD, -a - b );
                final int lastIndex = searchLastPosition(cCartesianD, -a - b );
                if (firstIndex != -1) {
                    result = result + lastIndex - firstIndex + 1;
                }
            }
        }
        return result;
    }
     */
    /*
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(D);
        int result = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    final int firstIndex = searchFirstPosition(D, -a - b - c);
                    final int lastIndex = searchLastPosition(D, -a - b - c);
                    if (firstIndex != -1) {
                        result = result + lastIndex - firstIndex + 1;
                    }
                }
            }
        }
        return result;
    }
     */
    /*
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    for (int d : D) {
                        if (a + b + c + d == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
     */

    private int searchFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int searchLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
