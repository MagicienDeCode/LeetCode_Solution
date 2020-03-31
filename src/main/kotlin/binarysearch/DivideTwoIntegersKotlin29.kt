package binarysearch

class DivideTwoIntegersKotlin29 {
    fun divide(dividend: Int, divisor: Int): Int {
        return when {
            dividend == Int.MIN_VALUE && divisor == -1 -> Int.MAX_VALUE
            divisor == 1 -> dividend
            divisor == -1 -> -dividend
            else -> {
                var flag = if (dividend < 0) -1 else 1
                flag = if (divisor < 0) -flag else flag
                var result = 0
                var remain = if (dividend > 0) -dividend else dividend
                val negativeDivisor = if (divisor > 0) -divisor else divisor
                var maxShifts = 0
                // search maxShiftsLeft with negativeDivisor that less than negativeDividend, log(n)
                if (negativeDivisor >= remain) {
                    var temp = negativeDivisor
                    while (temp >= remain - temp) {
                        temp += temp
                        maxShifts++
                    }
                    result += 1.shl(maxShifts)
                    remain -= negativeDivisor.shl(maxShifts)
                }
                // from maxShiftsLeft to 0 , find some value that make sum equal to remain, log(n)
                while (negativeDivisor >= remain) {
                    maxShifts--
                    if (negativeDivisor.shl(maxShifts) >= remain) {
                        remain -= negativeDivisor.shl(maxShifts)
                        result += 1.shl(maxShifts)
                    }
                }
                return if (flag < 0) -result else result
            }
        }
    }
}
/*
fun divide(dividend: Int, divisor: Int): Int {
    return when {
        dividend == Int.MIN_VALUE && divisor == -1 -> Int.MAX_VALUE
        divisor == 1 -> dividend
        divisor == -1 -> -dividend
        else -> {
            var flag = if (dividend < 0) -1 else 1
            flag = if (divisor < 0) -flag else flag
            var result = 0
            var total = if (dividend < 0) -dividend else dividend
            val positiveDivisor = if (divisor < 0) -divisor else divisor
            while (positiveDivisor <= total) {
                var count = 0
                while (positiveDivisor.shl(count) <= total) {
                    count++
                }
                result += 1.shl(--count)
                total -= positiveDivisor.shl(count)
            }
            return if (flag < 0) -result else result
        }
    }
}*/
