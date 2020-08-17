package list_array

class DistributeCandiestoPeopleKotlin1103 {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        val result = IntArray(num_people)
        var current = candies
        var index = 0
        var given = 1
        while (current > 0) {
            if (current - given >= 0) {
                result[index % num_people] += given
            } else {
                result[index % num_people] += current
            }
            current -= given
            ++index
            ++given
        }
        return result
    }
}

fun main() {
    val solution = DistributeCandiestoPeopleKotlin1103()
    // 1 2 3 1
    solution.distributeCandies(7, 4).forEach(::print)
}