package leetcode.easy

fun removeElement(nums: IntArray, `val`: Int): Int {
    var curIndex = 0

    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[curIndex] = nums[i]
            curIndex++
        }
    }

    return curIndex
}

fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    println(removeElement(nums, 2))
    println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}