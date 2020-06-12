package hash_map_set

import kotlin.random.Random

class InsertDeleteGetRandomO1DuplicatesallowedKotlin381 {
    /** Initialize your data structure here. */
    private val arrayList: MutableList<Int> = ArrayList()
    private val map: MutableMap<Int, MutableList<Int>> = HashMap()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        return if (map.containsKey(`val`)) {
            map.getValue(`val`).add(arrayList.size)
            arrayList.add(`val`)
            false
        } else {
            val mutableList: MutableList<Int> = ArrayList()
            mutableList.add(arrayList.size)
            map[`val`] = mutableList
            arrayList.add(`val`)
            true
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        return if (!map.containsKey(`val`)) {
            false
        } else {
            val removeValIndexList = map.getValue(`val`)
            val removeIndex = removeValIndexList[0]
            if (removeValIndexList.size == 1) {
                map.remove(`val`)
            } else {
                removeValIndexList.removeAt(0)
            }
            if (removeIndex != arrayList.size - 1) {
                val exchangeVal = arrayList[arrayList.size - 1]
                arrayList[removeIndex] = exchangeVal
                val exchangeValList = map.getValue(exchangeVal)
                exchangeValList.remove(arrayList.size - 1)
                exchangeValList.add(removeIndex)
            }
            arrayList.removeAt(arrayList.size - 1)
            true
        }
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return arrayList[Random.Default.nextInt(arrayList.size)]
    }
}

fun main() {
    val solution = InsertDeleteGetRandomO1DuplicatesallowedKotlin381()
    solution.insert(1)
    solution.insert(1)
    solution.insert(2)
    solution.insert(2)
    solution.insert(2)
    solution.remove(1)
    solution.remove(1)
    solution.remove(2)
    solution.insert(1)
    solution.remove(2)
}