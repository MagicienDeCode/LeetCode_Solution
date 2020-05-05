package nottcategorized

class ComplementofBase10IntegerKotlin1009 {
    fun bitwiseComplement(N: Int): Int {
        if (N == 0) {
            return 1
        }
        var flag = Int.MAX_VALUE
        while (flag.and(N) != 0) {
            flag = flag.shl(1)
        }
        return (flag.inv()).and(N.inv())
    }
}