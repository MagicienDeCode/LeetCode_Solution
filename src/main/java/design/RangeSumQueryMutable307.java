package design;

public class RangeSumQueryMutable307 {

    private final int total;
    private final int[] bit;
    private final int[] nums;

    public RangeSumQueryMutable307(int[] nums) {
        total = nums.length + 1;
        bit = new int[total];
        this.nums = nums;
        for (int i = 1; i < total; i++) {
            addToBit(i, nums[i - 1]);
        }
    }

    private void addToBit(int index, int num) {
        while (index < total) {
            bit[index] += num;
            index += index & -index;
        }
    }

    private int getByIndex(int index) {
        int result = 0;
        while (index > 0) {
            result += bit[index];
            index -= index & -index;
        }
        return result;
    }

    public void update(int index, int val) {
        final int delta = val - nums[index];
        nums[index] = val;
        addToBit(index + 1, delta);
    }

    public int sumRange(int left, int right) {
        return getByIndex(right + 1) - getByIndex(left);
    }
}
