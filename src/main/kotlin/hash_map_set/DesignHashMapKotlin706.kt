package hash_map_set

class DesignHashMapKotlin706 {

    /** Initialize your data structure here. */
    private val table = IntArray(1000001) { -1 }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        table[key] = value
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return table[key]
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        table[key] = -1
    }
}