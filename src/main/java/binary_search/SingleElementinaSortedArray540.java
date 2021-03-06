package binary_search;

public class SingleElementinaSortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        int left = 1;
        int right = nums.length - 2;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (isSingle(nums, mid)) {
                return nums[mid];
            } else {
                if (singleInLeft(nums, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (isSingle(nums, left)) {
            return nums[left];
        }
        return nums[right];
    }

    private boolean isSingle(final int[] nums, final int index) {
        return nums[index] != nums[index - 1] && nums[index] != nums[index + 1];
    }

    // return true ==> single element is in your left, so right = mid
    // return false ==> in your right, so left = mid
    private boolean singleInLeft(final int[] nums, final int notSingle) {
        if (nums[notSingle] == nums[notSingle - 1] && notSingle % 2 == 0) {
            return true;
        }
        return nums[notSingle] != nums[notSingle - 1] && notSingle % 2 != 0;
        /*
        if(nums[notSingle] == nums[notSingle-1]){
            if(notSingle%2 ==0){
                return true;
            }else{
                return false;
            }
        }else{
            if(notSingle%2==0){
                return false;
            }else {
                return true;
            }
        }
         */
    }
}
