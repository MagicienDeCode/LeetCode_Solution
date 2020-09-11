package string_integer

class BullsandCowsKotlin299 {
    /*
    1 1 2 3     s
    0 1 1 1     g

    count[1] = 1
    count[0] = -1

    bulls = 1

    count[1] = 1 > 0 ==> cows = 1
    count[2] = 1
    count[1] = 0
     */
    fun getHint(secret: String, guess: String): String? {
        val count = IntArray(10)
        var bulls = 0
        var cows = 0
        for (i in guess.indices) {
            val s = secret[i] - '0'
            val g = guess[i] - '0'
            if (s == g) {
                ++bulls
            } else {
                if (count[s] < 0) {
                    ++cows
                }
                if (count[g] > 0) {
                    ++cows
                }
                ++count[s]
                --count[g]
            }
        }
        return bulls.toString() + "A" + cows + "B"
    }
}