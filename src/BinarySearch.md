# [Presentation Link](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/BS_ALL_IN_ONE.pdf)

## Index

- Binary Search

| # | Title | Youtube | bilibili | ixiagua |
|:---:|:---:|:---:|:---:|:---:|
|0|[All In One](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/BS_ALL_IN_ONE.pdf)|[Youtube](https://www.youtube.com/watch?v=vs4jGMu5djk)|[bilibili](https://www.bilibili.com/video/BV1Va4y1e7Yf/)|[ixigua](https://www.ixigua.com/i6844933379972923908/)|


- Template
```$java
    public int searchLastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // avoid dead loop
        while (left + 1 < right) {
            // avoid integer overflow
            final int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // last position
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
```

- search the ( exact ) ( position / element ).

| # | Title | Java | Kotlin | Difficulty | Youtube | bilibili | ixiagua |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|1|[704. Binary Search](https://leetcode.com/problems/binary-search/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/BinarySearch704.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/BinarySearchKotlin704.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=boLrycDV8jA)|[bilibili](https://www.bilibili.com/video/av97758021/)|[ixigua](https://www.ixigua.com/i6806012949392523783/)|
|2|[167. Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/TwoSumIIInputarrayissorted167.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/TwoSumIIInputarrayissortedKotlin167.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=d8AH_G02qLo)|[bilibili](https://www.bilibili.com/video/BV1U741117sh/)|[ixigua](https://www.ixigua.com/i6807499056638591496/)|
|3|[35. Search Insert Position](https://leetcode.com/problems/search-insert-position/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SearchInsertPosition35.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SearchInsertPositionKotlin35.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=ni7gGKfdXgY)|[bilibili](https://www.bilibili.com/video/BV1DE411w75S/)|[ixigua](https://www.ixigua.com/i6806729161852322317/)|
|4|[350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/IntersectionofTwoArraysII350.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/IntersectionofTwoArraysIIKotlin350.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=fORR0VMGFHE)|[bilibili](https://www.bilibili.com/video/BV1y7411y7Uo/)|[ixigua](https://www.ixigua.com/i6807899212567544333/)|
|5|[374. Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/GuessNumberHigherorLower374.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/GuessNumberHigherorLowerKotlin374.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=x3gDd63dojE)|[bilibili](https://www.bilibili.com/video/BV1m54y1R7ic/)|[ixigua](https://www.ixigua.com/i6808473551973122563/)|
|6|[392. Is Subsequence](https://leetcode.com/problems/is-subsequence/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/IsSubsequence392.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/IsSubsequenceKotlin392.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=q374e-ND5eI)|[bilibili](https://www.bilibili.com/video/BV1Dt4y1m7ZN/)|[ixigua](https://www.ixigua.com/i6808880813128548876/)|
|7|[852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/PeakIndexinaMountainArray852.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/PeakIndexinaMountainArrayKotlin852.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=vDJ4hg9NiMs)|[bilibili](https://www.bilibili.com/video/BV1Lt4y1U7ja/)|[ixigua](https://www.ixigua.com/i6809231288407425539/)|
|8|[162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindPeakElement162.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindPeakElementKotlin162.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=hPhDZsNrtwU)|[bilibili](https://www.bilibili.com/video/BV1Bf4y1U7SF/)|[ixigua](https://www.ixigua.com/i6813050249406317069/)|
|9|[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/Searcha2DMatrix74.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/Searcha2DMatrixKotlin74.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=BsjTsw0c0W8)|[bilibili](https://www.bilibili.com/video/BV1rA41187fx/)|[ixigua](https://www.ixigua.com/i6811836955211334158/)|
|10|[240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/Searcha2DMatrixII240.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/Searcha2DMatrixIIKotlin240.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=PrPb6M7BgGg)|[bilibili](https://www.bilibili.com/video/BV12Z4y1x7Np/)|[ixigua](https://www.ixigua.com/i6815621227667784196/)|
|11|[441. Arranging Coins](https://leetcode.com/problems/arranging-coins/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/ArrangingCoins441.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/ArrangingCoinsKotlin441.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=9qaD15qIwsc)|[bilibili](https://www.bilibili.com/video/BV1RT4y1G73G/)|[ixigua](https://www.ixigua.com/i6818309866164060679/)|
|12|[475. Heaters](https://leetcode.com/problems/heaters/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/Heaters475.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/HeatersKotlin475.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=bJw2cQPOv5g)|[bilibili](https://www.bilibili.com/video/BV1u54y1R7c2/)|[ixigua](https://www.ixigua.com/i6819034637126337036/)|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|13|[1095. Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindinMountainArray1095.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindinMountainArrayKotlin1095.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=EQ-KUHSH05w)|[bilibili](https://www.bilibili.com/video/BV1ga4y1e7Ck/)|[ixigua](https://www.ixigua.com/i6841963827249021454/)|

- search the ( first / last ) ( position / element ).

| # | Title | Java | Kotlin | Difficulty | Youtube | bilibili | ixiagua |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|1|[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/Sqrt69.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SqrtKotlin69.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=Gc6u8LdSgIU)|[bilibili](https://www.bilibili.com/video/BV157411m7CG/)|[ixigua](https://www.ixigua.com/i6807105613600915982/)|
|2|[367. Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/ValidPerfectSquare367.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/ValidPerfectSquareKotlin367.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=uihXqsiIaJ8)|[bilibili](https://www.bilibili.com/video/BV1p7411C7x6/)|[ixigua](https://www.ixigua.com/i6808189102215660035/)|
|3|[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindFirstandLastPositionofElementinSortedArray34.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindFirstandLastPositionofElementinSortedArrayKotlin34.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=yePzwrN3is8)|[bilibili](https://www.bilibili.com/video/av98033532/)|[ixigua](https://www.ixigua.com/i6806360339840500235/)|
|4|[278. First Bad Version](https://leetcode.com/problems/first-bad-version/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FirstBadVersion278.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FirstBadVersionKotlin278.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=JsC5v2xUlV0)|[bilibili](https://www.bilibili.com/video/BV1X741117cm/)|[ixigua](https://www.ixigua.com/i6807564285368074756/)|
|5|[1337. The K Weakest Rows in a Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/TheKWeakestRowsinaMatrix1337.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/TheKWeakestRowsinaMatrixKotlin1337.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=XluwEvntPDA)|[bilibili](https://www.bilibili.com/video/BV18K4y1C7Ga/)|[ixigua](https://www.ixigua.com/i6809673096488813059/)|
|6|[1351. Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/CountNegativeNumbersinaSortedMatrix1351.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/CountNegativeNumbersinaSortedMatrixKotlin1351.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=PodFCIwMFgE)|[bilibili](https://www.bilibili.com/video/BV1cQ4y1M7Es/)|[ixigua](https://www.ixigua.com/i6810023565945995787/)|
|7|[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/LongestIncreasingSubsequence300.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/LongestIncreasingSubsequenceKotlin300.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=bns-CON63mY)|[bilibili](https://www.bilibili.com/video/BV1CA411b7Gu/)|[ixigua](https://www.ixigua.com/i6817067056232399363/)|
|8|[454. 4Sum II](https://leetcode.com/problems/4sum-ii/submissions/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FourSumII454.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FourSumIIKotlin454.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=fG1LrFUWVo0)|[bilibili](https://www.bilibili.com/video/BV17Q4y1N7Mm/)|[ixigua](https://www.ixigua.com/i6818593135082340875/)|
|9|[528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/RandomPickwithWeight528.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/RandomPickwithWeightKotlin528.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=9dI9fi7MGEA)|[bilibili](https://www.bilibili.com/video/BV1Qp4y1X71z/)|[ixigua](https://www.ixigua.com/i6820810418794005005/)|
|10|[497. Random Point in Non-overlapping Rectangles](https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/RandomPointinNonoverlappingRectangles497.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/RandomPointinNonoverlappingRectanglesKotlin497.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=Kb7_eb8xDnE)|[bilibili](https://www.bilibili.com/video/BV1LK41157Xg/)|[ixigua](https://www.ixigua.com/i6821192499910935043/)|
|11|[911. Online Election](https://leetcode.com/problems/online-election/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/OnlineElection911.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/OnlineElectionKotlin911.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=HAQVO9omNX0)|[bilibili](https://www.bilibili.com/video/BV1hK4y1k7Vx/)|[ixigua](https://www.ixigua.com/i6821578336431505931/)|
|12|[981. Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/TimeBasedKeyValueStore981.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/TimeBasedKeyValueStoreKotlin981.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=77gcjiODWg8)|[bilibili](https://www.bilibili.com/video/BV14a4y1i7GS/)|[ixigua](https://www.ixigua.com/i6822010573882917387/)|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|13|[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/MedianofTwoSortedArrays4.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/MedianofTwoSortedArraysKotlin4.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=lVq-fHMcjbw)|[bilibili](https://www.bilibili.com/video/BV1BK411W7K4/)|[ixigua](https://www.ixigua.com/i6826652950291546638/)|
|14|[315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/CountofSmallerNumbersAfterSelf315.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/CountofSmallerNumbersAfterSelfKotlin315.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=qGXw_WnvSpo)|[bilibili](https://www.bilibili.com/video/BV18T4y1u7DH/)|[ixigua](https://www.ixigua.com/i6827570372058022414/)|
|15|[327. Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/CountofRangeSum327.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/CountofRangeSumKotlin327.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=yOPUj2vBY-k)|[bilibili](https://www.bilibili.com/video/BV1bf4y1U7Bv/)|[ixigua](https://www.ixigua.com/i6828585110296592903/)|
|16|[352. Data Stream as Disjoint Intervals](https://leetcode.com/problems/data-stream-as-disjoint-intervals/submissions/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/DataStreamasDisjointIntervals352.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/DataStreamasDisjointIntervalsKotlin352.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=BNCTMm9O9PI)|[bilibili](https://www.bilibili.com/video/BV1J54y1D7oF/)|[ixigua](https://www.ixigua.com/i6828954380155224589/)|
|17|[354. Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/RussianDollEnvelopes354.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/RussianDollEnvelopesKotlin354.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=fMYpmM9iD_Q)|[bilibili](https://www.bilibili.com/video/BV1si4y1s7vu/)|[ixigua](https://www.ixigua.com/i6829653815432577540/)|
|18|[363. Max Sum of Rectangle No Larger Than K](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/MaxSumofRectangleNoLargerThanK363.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/MaxSumofRectangleNoLargerThanKKotlin363.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=fu3bKg65DTQ)|[bilibili](https://www.bilibili.com/video/BV1154y1D7GH/)|[ixigua](https://www.ixigua.com/i6831291181586973187/)|
|19|[493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/ReversePairs493.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/ReversePairsKotlin493.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=AGmV73n-0IQ)|[bilibili](https://www.bilibili.com/video/BV17Z4y1W7zp/)|[ixigua](https://www.ixigua.com/i6834569381746311688/)|
|20|[862. Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/ShortestSubarraywithSumatLeastK862.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/ShortestSubarraywithSumatLeastKKotlin862.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=13L3N4OcFKM)|[bilibili](https://www.bilibili.com/video/BV1PK4y1b7qY/)|[ixigua](https://www.ixigua.com/i6837158304150454795/)|
|21|[887. Super Egg Drop](https://leetcode.com/problems/super-egg-drop/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SuperEggDrop887.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SuperEggDropKotlin887.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=vhcAHiaNbc8)|[bilibili](https://www.bilibili.com/video/BV1BK411p7FA/)|[ixigua](https://www.ixigua.com/i6840853387588665867/)|
|22|[1157. Online Majority Element In Subarray](https://leetcode.com/problems/online-majority-element-in-subarray/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/OnlineMajorityElementInSubarray1157.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/OnlineMajorityElementInSubarrayKotlin1157.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=RYd1WJu_hVw)|[bilibili](https://www.bilibili.com/video/BV1Pk4y1672E/)|[ixigua](https://www.ixigua.com/i6842349350484443651/)|

- search with complex conditions

| # | Title | Java | Kotlin | Difficulty | Youtube | bilibili | ixiagua |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|1|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SearchinRotatedSortedArray33.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SearchinRotatedSortedArrayKotlin33.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=Am9gf6YWMXE)|[bilibili](https://www.bilibili.com/video/BV1WC4y1s7Hz/)|[ixigua](https://www.ixigua.com/i6810834712366416395/)|
|2|[81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SearchinRotatedSortedArrayII81.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SearchinRotatedSortedArrayIIKotlin81.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=O1Tvkx6rBeM)|[bilibili](https://www.bilibili.com/video/BV1je411474A/)|[ixigua](https://www.ixigua.com/i6812248016712368654/)|
|3|[153. Find Minimum in Rotated Sorted Array & 154](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindMinimuminRotatedSortedArray153.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindMinimuminRotatedSortedArrayKotlin153.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=pLMI2m0bX6g)|[bilibili](https://www.bilibili.com/video/BV1rK411L7mq/)|[ixigua](https://www.ixigua.com/i6812650258699387406/)|
|4|[275. H-Index II](https://leetcode.com/problems/h-index-ii/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/HIndexII275.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/HIndexIIKotlin275.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=e3Kb-ZbxZ-A)|[bilibili](https://www.bilibili.com/video/BV1FT4y1V7ia/)|[ixigua](https://www.ixigua.com/i6816084563010257420/)|
|5|[658. Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindKClosestElements658.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindKClosestElementsKotlin658.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=Q1sLutzezmw)|[bilibili](https://www.bilibili.com/video/BV1Yk4y1r7RE/)|[ixigua](https://www.ixigua.com/i6819424828404007431/)|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|6|[710. Random Pick with Blacklist](https://leetcode.com/problems/random-pick-with-blacklist/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/RandomPickwithBlacklist710.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/RandomPickwithBlacklistKotlin710.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=WTeUb87C1iw)|[bilibili](https://www.bilibili.com/video/BV1Kf4y1176V/)|[ixigua](https://www.ixigua.com/i6838702538183672332/)|

- binary search the result range with a verification function

| # | Title | Java | Kotlin | Difficulty | Youtube | bilibili | ixiagua |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|1|[378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/KthSmallestElementinaSortedMatrix378.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/KthSmallestElementinaSortedMatrixKotlin378.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=YOVeHZKYkw0)|[bilibili](https://www.bilibili.com/video/BV13A411b7Hi/)|[ixigua](https://www.ixigua.com/i6817412787757646349/)|
|2|[718. Maximum Length of Repeated Subarray](https://leetcode.com/problems/maximum-length-of-repeated-subarray/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/MaximumLengthofRepeatedSubarray718.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/MaximumLengthofRepeatedSubarrayKotlin718.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=WnNSjS3oq8M)|[bilibili](https://www.bilibili.com/video/BV1q54y1Q76g/)|[ixigua](https://www.ixigua.com/i6819995856633070087/)|
|3|[875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/KokoEatingBananas875.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/KokoEatingBananasKotlin875.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=HDoXrrbhUyc)|[bilibili](https://www.bilibili.com/video/BV1Sg4y1z7a9/)|[ixigua](https://www.ixigua.com/i6820449678463599108/)|
|4|[1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/CapacityToShipPackagesWithinDDays1011.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/CapacityToShipPackagesWithinDDaysKotlin1011.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=dWAaB8Z_cew)|[bilibili](https://www.bilibili.com/video/BV1yK4y1b7z8/)|[ixigua](https://www.ixigua.com/i6822266557159178763/)|
|5|[1482. Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/MinimumNumberofDaystoMakemBouquets1482.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/MinimumNumberofDaystoMakemBouquetsKotlin1482.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=MqdMvPPQ5pI)|[bilibili](https://www.bilibili.com/video/BV1CT4y177fA/)|[ixigua](https://www.ixigua.com/i6844149741412942339/)|
|6|[1201. Ugly Number III](https://leetcode.com/problems/ugly-number-iii/submissions/ )|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/UglyNumberIII1201.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/UglyNumberIIIKotlin1201.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=j0_h4MoUUwE)|[bilibili](https://www.bilibili.com/video/BV1Bf4y1m7u6/)|[ixigua](https://www.ixigua.com/i6823305306936705547/)|
|7|[1283. Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindtheSmallestDivisorGivenaThreshold1283.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindtheSmallestDivisorGivenaThresholdKotlin1283.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=q36SAn0JaS0)|[bilibili](https://www.bilibili.com/video/BV1yZ4y1s7cy/)|[ixigua](https://www.ixigua.com/i6823727970549498375/)|
|8|[1300. Sum of Mutated Array Closest to Target](https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SumofMutatedArrayClosesttoTarget1300.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SumofMutatedArrayClosesttoTargetKotlin1300.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=_UpY3SZY57A)|[bilibili](https://www.bilibili.com/video/BV1Rt4y1y7H5/)|[ixigua](https://www.ixigua.com/i6822660783244050947/)|
|9|[1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold](https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold1292.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/MaximumSideLengthofaSquarewithSumLessthanorEqualtoThresholdKotlin1292.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=3t7gSc4lR3E)|[bilibili](https://www.bilibili.com/video/BV1qf4y1m7FT/)|[ixigua](https://www.ixigua.com/i6824237791673582087/)|
|10|[540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SingleElementinaSortedArray540.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SingleElementinaSortedArrayKotlin540.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=O2zFa0dt_Hg)|[bilibili](https://www.bilibili.com/video/BV1BZ4y1s7e9/)|[ixigua](https://www.ixigua.com/i6825894153688187403/)|
|11|[410. Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SplitArrayLargestSum410.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SplitArrayLargestSumKotlin410.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=rifiw8EDf4c)|[bilibili](https://www.bilibili.com/video/BV13z411i7rR/)|[ixigua](https://www.ixigua.com/i6833454043868693004/)|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|12|[483. Smallest Good Base](https://leetcode.com/problems/smallest-good-base/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SmallestGoodBase483.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SmallestGoodBaseKotlin483.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=6k3PgRDm6fo)|[bilibili](https://www.bilibili.com/video/BV1UV411r7gz/)|[ixigua](https://www.ixigua.com/i6833818384497377803/)|
|13|[668. Kth Smallest Number in Multiplication Table](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/KthSmallestNumberinMultiplicationTable668.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/KthSmallestNumberinMultiplicationTableKotlin668.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=QFD6Z-8BSPM)|[bilibili](https://www.bilibili.com/video/BV1aa4y1v7pk/)|[ixigua](https://www.ixigua.com/i6834886823492190728/)|
|14|[719. Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindKthSmallestPairDistance719.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindKthSmallestPairDistanceKotlin719.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=Ep19tZjat0c)|[bilibili](https://www.bilibili.com/video/BV1fC4y1h7Xr/)|[ixigua](https://www.ixigua.com/i6836025818695598604/)|
|15|[778. Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/SwiminRisingWater778.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/SwiminRisingWaterKotlin778.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=W3gnJo6vHlg)|[bilibili](https://www.bilibili.com/video/BV1uf4y1m73o/)|[ixigua](https://www.ixigua.com/i6836477625448268300/)|
|16|[786. K-th Smallest Prime Fraction](https://leetcode.com/problems/k-th-smallest-prime-fraction/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/KthSmallestPrimeFraction786.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/KthSmallestPrimeFractionKotlin786.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=rDCCsV6WD10)|[bilibili](https://www.bilibili.com/video/BV1yT4y1E7yK/)|[ixigua](https://www.ixigua.com/i6836775823949693452/)|
|17|[793. Preimage Size of Factorial Zeroes Function](https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/PreimageSizeofFactorialZeroesFunction793.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/PreimageSizeofFactorialZeroesFunctionKotlin793.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=1u_UIJYK7aY)|[bilibili](https://www.bilibili.com/video/BV1W54y1B7xM/)|[ixigua](https://www.ixigua.com/i6838996225560150532/)|
|18|[878. Nth Magical Number](https://leetcode.com/problems/nth-magical-number/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/NthMagicalNumber878.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/NthMagicalNumberKotlin878.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=Uarm4XBes9g)|[bilibili](https://www.bilibili.com/video/BV1zT4y1J76p/)|[ixigua](https://www.ixigua.com/i6839697004164022787/)|
|19|[1044. Longest Duplicate Substring](https://leetcode.com/problems/longest-duplicate-substring/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/LongestDuplicateSubstring1044.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/LongestDuplicateSubstringKotlin1044.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=VN93iodnwhk)|[bilibili](https://www.bilibili.com/video/BV1Pz4y1R72d/)|[ixigua](https://www.ixigua.com/i6840094708799111691/)|

- other 

| # | Title | Java | Kotlin | Difficulty | Youtube | bilibili | ixiagua |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|1|[349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/IntersectionofTwoArrays349.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/IntersectionofTwoArraysKotlin349.kt)|Easy|[Youtube](https://www.youtube.com/watch?v=fORR0VMGFHE)|[bilibili](https://www.bilibili.com/video/BV1y7411y7Uo/)|[ixigua](https://www.ixigua.com/i6807899212567544333/)|
|2|[29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/DivideTwoIntegers29.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/DivideTwoIntegersKotlin29.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=RKa94srw8cQ)|[bilibili](https://www.bilibili.com/video/BV1WZ4y1j7QK/)|[ixigua](https://www.ixigua.com/i6810520614751699468/)|
|3|[50. Pow(x, n)](https://leetcode.com/problems/powx-n/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/Powxn50.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/PowxnKotlin50.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=OhIBzlxog1E)|[bilibili](https://www.bilibili.com/video/BV1Ke411x7mU/)|[ixigua](https://www.ixigua.com/i6811168058392969731/)|
|4|[209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/MinimumSizeSubarraySum209.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/MinimumSizeSubarraySumKotlin209.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=m53zbDdpI2E)|[bilibili](https://www.bilibili.com/video/BV1LC4y1s7sG/)|[ixigua](https://www.ixigua.com/i6813423341886505484/)|
|5|[222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/CountCompleteTreeNodes222.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/CountCompleteTreeNodesKotlin222.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=V8VyaeT0fYA)|[bilibili](https://www.bilibili.com/video/BV1Qk4y197An/)|[ixigua](https://www.ixigua.com/i6814433746394022404/)|
|6|[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/KthSmallestElementinaBST230.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/KthSmallestElementinaBSTKotlin230.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=YvgbbGjuVPY)|[bilibili](https://www.bilibili.com/video/BV1qC4y1s7Hk/)|[ixigua](https://www.ixigua.com/i6815199865195201027/)|
|7|[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindtheDuplicateNumber287.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindtheDuplicateNumberKotlin287.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=ygiQJzzblP8)|[bilibili](https://www.bilibili.com/video/BV1st4y1277B/)|[ixigua](https://www.ixigua.com/i6816443653460853251/)|
|8|[436. Find Right Interval](https://leetcode.com/problems/find-right-interval/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/FindRightInterval436.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/FindRightIntervalKotlin436.kt)|Medium|[Youtube](https://www.youtube.com/watch?v=3iF0bUDVQ0E)|[bilibili](https://www.bilibili.com/video/BV1664y1T7YW/)|[ixigua](https://www.ixigua.com/i6817867831019831819/)|
|9|[927. Three Equal Parts](https://leetcode.com/problems/three-equal-parts/)|[Java](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/java/binary_search/ThreeEqualParts927.java)|[Kotlin](https://github.com/MagicienDeCode/LeetCode_Solution/blob/master/src/main/kotlin/binary_search/ThreeEqualPartsKotlin927.kt)|Hard|[Youtube](https://www.youtube.com/watch?v=vhcAHiaNbc8)|[bilibili](https://www.bilibili.com/video/BV1kD4y1D7PQ/)|[ixigua](https://www.ixigua.com/i6841588029421781512/)|
    