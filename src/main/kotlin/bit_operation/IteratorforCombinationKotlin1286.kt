package bit_operation

// Copy from exlevan
class IteratorforCombinationKotlin1286(characters: String, combinationLength: Int) {

    private var bit: Int = 1.shl(characters.length) -
            1.shl(characters.length - combinationLength)
    private val length: Int = combinationLength
    private val chars: CharArray = characters.toCharArray()

    fun next(): String {
        val result = CharArray(length)
        var b = bit
        var indexChar = chars.size - 1
        var indexResult = length - 1
        while (indexResult >= 0) {
            if (b.and(1) == 1) {
                result[indexResult] = chars[indexChar]
                --indexResult
            }
            b = b.shr(1)
            --indexChar
        }

        // Calculate the next combination
        // To get the next combination, we're performing the following steps
        //   (for example, let's assume we're starting with 01100011):
        // 1. Remove all trailing 1's from the end of the bitmask (by doing bits & (bits + 1)
        //    01100011 -> 01100000
        // 2. Take the last 1 that is followed by 0s, and shift it one position to the right,
        //    filling the remaining bits with 1's. That's can be done by decrementing the value
        //    01100000 -> 0101111
        // 3. Remove some 1s from the end to restore total number of 1s in the mask. This
        //    can be done by calculating the number of different bits between the current and
        //    starting bitmask, and shifting number to the right, then to the left by that value.
        //    0101111 -> 0101110

        val b1 = bit.and(bit + 1) - 1
        val shift = Integer.bitCount(bit.xor(b1)) - 2
        bit = b1.shr(shift).shl(shift)

        return String(result)
    }

    fun hasNext(): Boolean {
        return bit > 0
    }
}