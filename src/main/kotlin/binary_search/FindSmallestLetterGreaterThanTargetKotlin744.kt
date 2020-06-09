package binary_search

class FindSmallestLetterGreaterThanTargetKotlin744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var left = 0
        var right = letters.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            if (letters[mid] <= target) {
                left = mid
            } else {
                right = mid
            }
        }
        return when {
            letters[left] > target -> letters[left]
            letters[right] > target -> letters[right]
            else -> letters[0]
        }
    }
}

fun main() {
    val solution = FindSmallestLetterGreaterThanTargetKotlin744()
    // c
    println(solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'a'))
    // f
    println(solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c'))
    // f
    println(solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'd'))
    // j
    println(solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'g'))
    // c
    println(solution.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'k'))
}