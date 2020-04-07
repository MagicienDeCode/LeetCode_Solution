package binarysearch

class PeakIndexinaMountainArrayKotlin852 {
    fun peakIndexInMountainArray(A: IntArray): Int {
        var left = 0
        var right = A.size
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                A[mid - 1] < A[mid] && A[mid] > A[mid + 1] -> return mid
                A[mid - 1] < A[mid] && A[mid] < A[mid + 1] -> left = mid
                A[mid - 1] > A[mid] && A[mid] > A[mid + 1] -> right = mid
            }
        }
        return when {
            A[left] > A[right] && A[left - 1] < A[left] -> left
            else -> right
        }
    }

    /*
        var left = 0
        var right = A.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                A[mid - 1] < A[mid] && A[mid] > A[mid + 1] -> return mid
                A[mid - 1] < A[mid] -> left = mid
                else -> right = mid
            }
        }
        return when {
            A[left] > A[right] -> left
            else -> right
        }
     */
}