package binarysearch

class IntersectionofTwoArraysIIKotlin350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums2.size < nums1.size) {
            return intersect(nums2, nums1)
        }
        val num1Map = mutableMapOf<Int, Int>()
        nums1.forEach { i -> num1Map[i] = num1Map.computeIfAbsent(i) { 0 } + 1 }
        val result = mutableListOf<Int>()
        nums2.forEach { i ->
            if (num1Map.containsKey(i) && num1Map.getValue(i) > 0) {
                result.add(i)
                num1Map[i] = num1Map.getValue(i).minus(1)
            }
        }
        return result.toIntArray()
    }
}