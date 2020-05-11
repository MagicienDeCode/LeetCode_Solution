package binary_search

class IntersectionofTwoArraysKotlin349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        return nums1.toHashSet().intersect(nums2.toHashSet()).toIntArray()
    }
}