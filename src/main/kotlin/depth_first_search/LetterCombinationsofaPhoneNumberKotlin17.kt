package depth_first_search


class LetterCombinationsofaPhoneNumberKotlin17 {

    private val phoneMap = mapOf(
            '1' to emptyList(),
            '2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z")
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }
        return digits.map { phoneMap.getValue(it) }.reduce { acc, list ->
            acc.flatMap { accItem -> list.map { listItem -> "$accItem$listItem" } }
        }
    }
}