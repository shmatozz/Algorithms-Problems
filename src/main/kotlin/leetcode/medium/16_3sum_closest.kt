package leetcode.medium

import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()

    var minSum = Int.MAX_VALUE

    for (first in 0 until nums.size - 2) {
        var left = first + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[first] + nums[left] + nums[right]

            if (sum > target) right--
            else if (sum < target) left++
            else return sum

            if (abs(sum - target) < abs(minSum - target)) minSum = sum
        }
    }

    return minSum
}

fun main() {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 21))
}