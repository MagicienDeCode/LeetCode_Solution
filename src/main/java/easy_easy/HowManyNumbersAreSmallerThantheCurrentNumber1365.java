package easy_easy;

public class HowManyNumbersAreSmallerThantheCurrentNumber1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        int sum = count[0];
        for (int i = 1; i < count.length; i++) {
            final int current = count[i];
            count[i] = sum;
            sum += current;
        }
        final int[] resultArray = new int[nums.length];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = nums[i] == 0 ? 0 : count[nums[i]];
        }
        return resultArray;
    }
}
