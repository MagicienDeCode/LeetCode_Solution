package tree

class StreamofCharactersKotlin1032(words: Array<String>) {
    val root = PrefixTree()
    val stringBuilder = StringBuilder()

    init {
        words.forEach { insert(it) }
    }

    fun query(letter: Char): Boolean {
        stringBuilder.append(letter)
        var current: PrefixTree? = root
        for (index in stringBuilder.length - 1 downTo 0) {
            if (current!!.isEnd) {
                return true
            }
            current = if (current.getByChar(stringBuilder[index]) != null) {
                current.getByChar(stringBuilder[index])
            } else {
                return false
            }
        }
        return current!!.isEnd
    }

    private fun insert(word: String) {
        var current: PrefixTree? = root
        for (index in word.length - 1 downTo 0) {
            if (current!!.getByChar(word[index]) == null) {
                current.addChar(word[index], PrefixTree())
            }
            current = current.getByChar(word[index])
        }
        current!!.isEnd = true
    }

    class PrefixTree {
        val links = arrayOfNulls<PrefixTree>(26)
        var isEnd = false
        fun addChar(c: Char, prefixTree: PrefixTree?) {
            links[c - 'a'] = prefixTree
        }

        fun getByChar(c: Char): PrefixTree? {
            return links[c - 'a']
        }
    }
}