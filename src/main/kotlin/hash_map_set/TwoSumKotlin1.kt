package hash_map_set

class TwoSumKotlin1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val valueIndexMap: MutableMap<Int, Int> = HashMap()
        valueIndexMap[nums[0]] = 0
        for (index in 1 until nums.size) {
            if (valueIndexMap.containsKey(target - nums[index])) {
                return intArrayOf(valueIndexMap.getValue(target - nums[index]), index)
            }
            valueIndexMap[nums[index]] = index
        }
        return intArrayOf()
    }
}