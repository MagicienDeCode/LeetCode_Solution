package binary_search

class UglyNumberKotlin263 {
    fun isUgly(num: Int): Boolean {
        if (num <= 0) {
            return false
        }
        var current = num
        while (current % 2 == 0) {
            current /= 2
        }
        while (current % 3 == 0) {
            current /= 3
        }
        while (current % 5 == 0) {
            current /= 5
        }
        return num == 1
    }
}