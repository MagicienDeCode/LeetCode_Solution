package not_categorized_easy;

public class SquaresofaSortedArray977 {
    public int[] sortedSquares(int[] nums) {
        final int[] result = new int[nums.length];
        if (nums.length == 0) {
            return result;
        }
        int index = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            final int leftSquare = nums[left] * nums[left];
            final int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                left++;
                result[index--] = leftSquare;
            } else {
                right--;
                result[index--] = rightSquare;
            }
        }
        return result;
    }
}
