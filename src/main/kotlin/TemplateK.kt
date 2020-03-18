class TemplateK {
    fun sum(a: Int, b: Int): Int = if (Int.MAX_VALUE - a < b) {
        0
    } else {
        a + b
    }
}