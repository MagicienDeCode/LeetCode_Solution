package union_find

import kotlin.math.sqrt

class LargestComponentSizebyCommonFactorKotlin952 {
    fun largestComponentSize(nums: IntArray): Int {
        val maxUfIndex = nums.max()!!
        val ufArray = IntArray(maxUfIndex + 1)
        for (i in ufArray.indices) {
            ufArray[i] = i
        }
        for (num in nums) {
            for (factor in sqrt(num.toDouble()).toInt() downTo 2) {
                if (num % factor == 0) {
                    ufArray[unionFind(ufArray, num)] = ufArray[unionFind(ufArray, factor)]
                    ufArray[unionFind(ufArray, num)] = ufArray[unionFind(ufArray, num / factor)]
                }
            }
        }
        val resultMap: MutableMap<Int, Int> = HashMap()
        var result = 0
        for (r in nums) {
            val uf = unionFind(ufArray, r)
            resultMap[uf] = resultMap.getOrDefault(uf, 0) + 1
            result = maxOf(result, resultMap.getValue(uf))
        }
        return result
    }

    private fun unionFind(arr: IntArray, target: Int): Int {
        return if (arr[target] == target) target else unionFind(arr, arr[target]).also { arr[target] = it }
    }
}