package string_integer

class LargestTimeforGivenDigitsKotlin949 {
    private var max_time = -1

    fun largestTimeFromDigits(nums: IntArray): String? {
        max_time = -1
        permutate(nums, 0)
        return if (max_time == -1) "" else String.format("%02d:%02d", max_time / 60, max_time % 60)
    }

    private fun permutate(array: IntArray, start: Int) {
        if (start == array.size) {
            build_time(array)
            return
        }
        for (i in start until array.size) {
            swap(array, i, start)
            permutate(array, start + 1)
            swap(array, i, start)
        }
    }

    private fun build_time(perm: IntArray) {
        val hour = perm[0] * 10 + perm[1]
        val minute = perm[2] * 10 + perm[3]
        if (hour < 24 && minute < 60) max_time = Math.max(max_time, hour * 60 + minute)
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        if (i != j) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }
}