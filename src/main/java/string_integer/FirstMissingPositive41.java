package string_integer;

public class FirstMissingPositive41 {

    /*
    [ 3 4 -1 1 ]
    i = 0, num[0] = 3
    swap 3 -1, [ -1 4 3 1 ]

    i = 1, nums[1] = 4
    swap 4 1, [ -1 1 3 4 ]
    nums[1] = 1
    swap 1 -1, [ 1 -1 3 4 ]
    nums[1] = -1, end

    i = 2, nums[2] = 3
    swap 3 -1, [ 1 3 -1 4 ]
    nums[2] = -1, end

    i = 3, nums[3] = 4
    swap 4 -1, [ 1 3 4 -1 ]
    nums[3] = -1, end
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            final int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


  /*
  public int firstMissingPositive(int[] nums) {
    final HashSet<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }
    int result = 1;
    while (true) {
      if (set.contains(result)) {
        ++result;
      } else {
        return result;
      }
    }
  }
   */
}
