package leetcode.medium

import kotlin.math.max

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }

    for (i in 1 until nums.size) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    return dp.max()
}

fun main() {
    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    println(lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
    println(lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
}