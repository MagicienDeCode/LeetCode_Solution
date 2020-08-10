package string_integer

class ExcelSheetColumnTitleKotlin168 {
    fun convertToTitle(n: Int): String {
        val resultBuilder = StringBuilder()
        var current = n
        while (current != 0) {
            val temp = --current % 26
            resultBuilder.append((temp + 65).toChar())
            current /= 26
        }
        return resultBuilder.reverse().toString()
    }
}

fun main() {
    val solution = ExcelSheetColumnTitleKotlin168()
    // ZY
    println(solution.convertToTitle(701))
    // Z
    println(solution.convertToTitle(26))
    // A
    println(solution.convertToTitle(1))
}