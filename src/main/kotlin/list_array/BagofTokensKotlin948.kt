package list_array

class BagofTokensKotlin948 {
    fun bagOfTokensScore(tokens: IntArray, powerVal: Int): Int {
        var power = powerVal
        tokens.sort()
        var left = 0
        var right = tokens.size - 1
        var points = 0
        var answer = 0
        while (left <= right && (power > tokens[left] || points > 0)) {
            while (left <= right && power >= tokens[left]) {
                power -= tokens[left++]
                points++
            }
            answer = Math.max(answer, points)
            if (left <= right && points > 0) {
                power += tokens[right--]
                points--
            }
        }
        return answer
    }
}