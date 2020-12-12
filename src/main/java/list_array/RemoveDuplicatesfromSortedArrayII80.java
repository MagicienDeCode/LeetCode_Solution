package list_array;

public class RemoveDuplicatesfromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int replaceIndex = 0;
        int count = 0;
        int current = Integer.MIN_VALUE;
        while (index < nums.length) {
            if (nums[index] == current) {
                if (count == 2) {
                    replaceIndex = index;
                    break;
                }
                count++;
            } else {
                current = nums[index];
                count = 1;
            }
            index++;
        }
        if (index == nums.length) {
            return index;
        }
        while (index < nums.length) {
            if (nums[index] == current) {
                if (count >= 2) {
                    index++;
                    continue;
                }
                ++count;
            } else {
                current = nums[index];
                count = 1;
            }
            nums[replaceIndex] = nums[index++];
            ++replaceIndex;
        }
        return replaceIndex;
    }
}
