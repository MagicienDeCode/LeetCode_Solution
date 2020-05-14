package binary_search

class MedianofTwoSortedArraysKotlin4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }
        if (nums1.isEmpty()) {
            return when {
                nums2.size % 2 == 1 -> nums2[nums2.size.div(2)].times(1.0)
                else -> (nums2[nums2.size.div(2)] +
                        nums2[nums2.size.div(2) - 1])
                    .div(2.0)
            }
        }
        val indexA = binarySearchIndexA(nums1, nums2)
        val indexB = (nums1.size + nums2.size + 1).shr(1) - indexA
        val maxOfLeftNum1AndNum2 = when {
            indexA == 0 -> nums2[indexB - 1]
            indexB == 0 -> nums1[indexA - 1]
            else -> maxOf(nums1[indexA - 1], nums2[indexB - 1])
        }
        if ((nums1.size + nums2.size) % 2 == 1) {
            return maxOfLeftNum1AndNum2.toDouble()
        }
        val minOfRightNum1AndNum2 = when {
            indexA == nums1.size -> nums2[indexB]
            indexB == nums2.size -> nums1[indexA]
            else -> minOf(nums1[indexA], nums2[indexB])
        }
        return (maxOfLeftNum1AndNum2 + minOfRightNum1AndNum2).div(2.0)
    }

    private fun binarySearchIndexA(nums1: IntArray, nums2: IntArray): Int {
        var left = 0
        var right = nums1.size
        val halfOfNum1AndNum2 = (nums1.size + nums2.size + 1) / 2
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            val index2 = halfOfNum1AndNum2 - mid
            when {
                index2 >= 1 && nums2[index2 - 1] > nums1[mid] -> left = mid
                mid >= 1 && nums1[mid - 1] > nums2[index2] -> right = mid
                else -> return mid
            }
        }
        val indexB = halfOfNum1AndNum2 - left
        return when {
            left == 0 && nums1[0] >= nums2[indexB - 1] -> left
            left == 0 && nums1[0] < nums2[indexB - 1] -> right
            maxOf(nums1[left - 1], nums2[indexB - 1]) < minOf(nums1[left], nums2[indexB]) -> left
            else -> right
        }
    }
}

fun main() {
    val soluton = MedianofTwoSortedArraysKotlin4()
    println(soluton.findMedianSortedArrays(intArrayOf(1, 2, 3), intArrayOf(4, 5)))
    println(soluton.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(soluton.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    println(soluton.findMedianSortedArrays(intArrayOf(), intArrayOf(1, 2, 3, 4)))
    println(soluton.findMedianSortedArrays(intArrayOf(1), intArrayOf(1)))
}