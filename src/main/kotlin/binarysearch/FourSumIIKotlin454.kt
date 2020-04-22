package binarysearch

class FourSumIIKotlin454 {
    /*
   fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
       if (A.isEmpty()) {
           return 0
       }
       // S(n*n) O(n*n)
       val cCartesianDMap = mutableMapOf<Int, Int>()
       C.forEach { c ->
           D.forEach { d ->
               cCartesianDMap[-c - d] = 1 + cCartesianDMap.computeIfAbsent(-c - d) { 0 }
           }
       }

       var result = 0
       // O(n*n)
       A.forEach { a ->
           B.forEach { b ->
               result += cCartesianDMap[a + b] ?: 0
           }
       }

       return result
   }
  */
   fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
       if (A.isEmpty()) {
           return 0
       }
       // S(n*n) O(n*n)
       val cCartesianD = C.flatMap { c -> D.map { d -> c + d } }.toIntArray()
       // n*n*log(n*n)
       cCartesianD.sort()

       var result = 0
       // n*n*log(n*n)
       A.flatMap { a -> B.map { b -> a + b } }.forEach {
           val firstIndex = searchFirstPosition(cCartesianD, -it)
           val lastIndex = searchLastPosition(cCartesianD, -it)
           if (firstIndex != -1) {
               result = result + lastIndex - firstIndex + 1
           }
       }

       return result
   }

    /*
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        // nlog(n)
        D.sort()
        var result = 0
        // n*n*n*log(n)
        A.forEach { a ->
            B.forEach { b ->
                C.forEach { c ->
                    val target = -a - b - c
                    val firstIndex = searchFirstPosition(D, target)
                    val lastIndex = searchLastPosition(D, target)
                    if (firstIndex != -1) {
                        result = result + lastIndex - firstIndex + 1
                    }
                }
            }
        }
        return result
    }
     */

    fun searchFirstPosition(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> right = mid
                nums[mid] < target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when (target) {
            nums[left] -> left
            nums[right] -> right
            else -> -1
        }
    }

    fun searchLastPosition(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> left = mid
                nums[mid] < target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when (target) {
            nums[right] -> right
            nums[left] -> left
            else -> -1
        }
    }

    /*
    Time Limit Exceeded
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        var result = 0
        // n*n*n*n
        A.forEach { a ->
            B.forEach { b ->
                C.forEach { c ->
                    D.forEach { d ->
                        if (a + b + c + d == 0) {
                            result++
                        }
                    }
                }
            }
        }
        return result
    }
     */
}

fun main() {
    val solution = FourSumIIKotlin454()
    println(solution.fourSumCount(intArrayOf(1, 2), intArrayOf(-2, -1), intArrayOf(-1, 2), intArrayOf(0, 2)))
    // 17
    println(
        solution.fourSumCount(
            intArrayOf(0, 1, -1),
            intArrayOf(-1, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(-1, 1, 1)
        )
    )
}