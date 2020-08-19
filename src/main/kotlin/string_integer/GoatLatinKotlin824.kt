package string_integer

class GoatLatinKotlin824 {
    fun toGoatLatin(s: String): String {
        val set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val maBuilder = StringBuilder("ma")
        val result = StringBuilder()
        for (each in s.split(" ").toTypedArray()) {
            maBuilder.append('a')
            if (!set.contains(each[0])) {
                result.append(each.substring(1) + each[0]).append(maBuilder.toString()).append(" ")
            } else {
                result.append(each).append(maBuilder.toString()).append(" ")
            }
        }
        result.deleteCharAt(result.length - 1)
        return result.toString()
    }
}