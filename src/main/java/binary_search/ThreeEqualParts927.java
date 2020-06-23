package binary_search;

class ThreeEqualParts927 {
    public int[] threeEqualParts(int[] nums) {
        int countOne = 0;
        for (int n : nums) {
            countOne += n;
        }
        if (countOne == 0) {
            return new int[]{0, nums.length - 1};
        }
        if (countOne % 3 != 0) {
            return new int[]{-1, -1};
        }
        final int numberOne = countOne / 3;
        int first = 0;
        int second = 0;
        int third = 0;
        int index = 0;
        while (nums[index] == 0) {
            ++first;
            ++index;
        }
        int countOfOne = 0;
        while (countOfOne != numberOne) {
            if (nums[index] == 1) {
                ++countOfOne;
            }
            ++index;
        }
        while (nums[index] == 0) {
            ++index;
        }
        second = index;
        countOfOne = 0;
        while (countOfOne != numberOne) {
            if (nums[index] == 1) {
                ++countOfOne;
            }
            ++index;
        }
        while (nums[index] == 0) {
            ++index;
        }
        third = index;
        while (third < nums.length &&
                nums[first] == nums[second] &&
                nums[first] == nums[third]) {
            ++third;
            ++second;
            ++first;
        }
        if (third == nums.length) {
            return new int[]{first - 1, second};
        } else {
            return new int[]{-1, -1};
        }
    }
}